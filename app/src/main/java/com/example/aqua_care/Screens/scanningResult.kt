package com.example.aqua_care.Screens

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.aqua_care.Camera.takePhoto
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.R
import com.example.aqua_care.ScanBot.utils.toFile
import com.example.aqua_care.ViewModel.ClassificationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scanningResult(
    modifier: Modifier = Modifier,
    navController: NavController,
    context : Context,
    classifyViewModel : ClassificationViewModel  = hiltViewModel()
){
    var isAlertShown by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    var capturedImage by remember { mutableStateOf<android.graphics.Bitmap?>(null) }
    var cameraActive by remember { mutableStateOf(true) }
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or
                        CameraController.VIDEO_CAPTURE
            )
        }
    }
    val state by classifyViewModel.state.collectAsStateWithLifecycle()
    Scaffold { paddingValues ->
        LaunchedEffect(key1 = state.error) {
            state.error?.let { error ->
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }
        }
        if (isAlertShown){
            AlertDialog(onDismissRequest =  {
                classifyViewModel.resetState()
                isAlertShown = false
            }
            ){
                Box(
                    modifier
                        .size(450.dp)
                        .padding(16.dp)
                        .background(Color(0xFFE6EFFD), RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ){
                    if (state.loading){
                        CircularProgressIndicator(
                            strokeWidth = 4.dp,
                            modifier = Modifier
                                .padding(16.dp)
                                .size(56.dp)
                        )
                    } else {
                        if (state.success){
                            state.result?.let {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(10.dp),
                                    modifier = modifier
                                        .padding(20.dp)
                                ){
                                    capturedImage?.let { bitmap ->
                                        Image(bitmap = bitmap.asImageBitmap(),
                                            contentDescription = null,
                                            modifier
                                                .size(150.dp)
                                        )
                                    }
                                    opensanstext(
                                        text = it.prediction ?: "",
                                        size = 16.sp,
                                        fontFamily = opensansregular,
                                        onItemclicked = {  },
                                        color = Color(0xFF272727)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            cameraPreview(
                controller = controller,
                modifier = modifier
                    .fillMaxSize()
            )
            IconButton(
                onClick = {
                    controller.cameraSelector = if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA){
                        CameraSelector.DEFAULT_FRONT_CAMERA
                    } else CameraSelector.DEFAULT_BACK_CAMERA
            },
                modifier
                    .offset(16.dp, 16.dp)
            ){
                Icon(painter = painterResource(id = R.drawable.cameraswitch),
                    contentDescription = "Camera Switch"
                )
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                IconButton(
                    onClick = {
                        takePhoto(controller = controller,
                            onPhotoTaken = {bitmap ->
                                val convertedImage = bitmap.toFile(context)
                                    classifyViewModel.uploadImage(convertedImage)
                                capturedImage = bitmap
                                isAlertShown = true
                            },
                            context = context,
                            onCameraOff = {
                                cameraActive = false
                            }
                        )
                    }
                ){
                    Icon(painter = painterResource(id = R.drawable.button_scan),
                        contentDescription = "Take Photo")
                }
            }
        }
    }
}


@Composable
fun cameraPreview(
    modifier: Modifier = Modifier,
    controller : LifecycleCameraController
){
    val lifecyclerOwner = LocalLifecycleOwner.current
    AndroidView(
        factory = {
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifecyclerOwner)
            }
        },
        modifier = modifier
    )
}