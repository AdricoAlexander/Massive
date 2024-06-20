package com.example.aqua_care.Screens

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Space
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.MainActivity
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun scanPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    context : Context
){
    var isClicked by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            modifier
                .fillMaxWidth()
                .height(72.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                opensanstext(
                    text = "Aqua Scan",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF246DBB)
                )
            }
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_backarrow),
                    contentDescription = null,
                    modifier
                        .size(29.dp)
                        .clickable {
                            navController.navigate(navScreen.homePage.route)
                        }
                )
            }
        }
        Spacer(
            modifier.height(16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.topline),
            contentDescription = null
        )
        Spacer(modifier.height(13.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            if (isClicked == true) {

            } else {
                Image(
                    painter = painterResource(id = R.drawable.flashlight),
                    contentDescription = null,
                    modifier
                        .size(33.dp)
                )
            }
            Spacer(
                modifier.height(47.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .fillMaxWidth()
                    .height(301.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.scanning_prototype_icon),
                    contentDescription = null,
                    modifier
                        .size(261.dp, 256.dp)
                )
            }
            opensanstext(
                text = "Scanning . . . . ",
                size = 18.sp,
                fontFamily = opensansbold,
                onItemclicked = { },
                color = Color(0xFF272727)
            )
            Spacer(
                modifier.height(38.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.button_scan),
                contentDescription = null,
                modifier
                    .size(89.dp)
                    .clickable {
                        navController.navigate(navScreen.scanningResult.route)
                    }
            )
        }
    }
}