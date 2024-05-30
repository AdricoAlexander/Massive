package com.example.aqua_care.Screens

import android.content.Context
import android.graphics.drawable.Icon
import android.widget.Space
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.aqua_care.Camera.PhotoBottomSheetContent
import com.example.aqua_care.Camera.takePhoto
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import com.example.aqua_care.ViewModel.cameraViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scanningResult(
    modifier: Modifier = Modifier,
    navController: NavController,
    context : Context
){
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val controller = remember {
        LifecycleCameraController(context).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE or
                CameraController.VIDEO_CAPTURE
            )
        }
    }
    val viewModel = viewModel<cameraViewModel>()
    val bitmaps by viewModel.bitmaps.collectAsState()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            PhotoBottomSheetContent(bitmaps = bitmaps,
                modifier = modifier
                    .fillMaxWidth())
        }
    ) { paddingValues ->
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
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.cameraswitch),
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
                        scope.launch {
                            scaffoldState.bottomSheetState.expand()
                        }
                    }
                ){
                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.opengallery),
                        contentDescription = "Open Gallery")
                }
                IconButton(
                    onClick = {
                        takePhoto(controller = controller,
                            onPhotoTaken = viewModel::onTakePhoto,
                            context = context)
                    }
                ){
                    androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.takephoto),
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