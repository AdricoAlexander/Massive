package com.example.aqua_care.ui.Presentation.Onboarding

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
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun landingPage_1(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(30.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier.height(30.dp)
            )
            Row (
                modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ){
                opensanstext(text = "Skip",
                    size = 16.sp,
                    fontFamily = opensansbold,
                    color = Color(0xFF246DBB),
                    onItemclicked = {
                        navController.navigate(navScreen.landingPage_3.route)
                    }
                )
            }
            Spacer(modifier.height(40.dp)
            )
            opensanstext(
                text = "Selamat Datang Di",
                size = 20.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            opensanstext(
                text = "Aqua Care",
                size = 20.sp,
                fontFamily = opensansbold,
                color = Color(0xFF246DBB),
                onItemclicked = null
            )
            Spacer(modifier.height(37.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.landing_image_1),
                contentDescription = null,
            )
            Spacer(modifier.height(37.dp)
            )
            opensanstext(
                text = "Air Bersih, Ikan Sehat, Sukses Terjaga",
                size = 16.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .fillMaxSize()
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.forward_arrow),
                            contentDescription = "Forward Arrow",
                            modifier
                                .clickable {
                                    navController.navigate(navScreen.landingPage_2.route)
                                }
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.onbar_landing),
                            contentDescription = null,
                            Modifier
                                .padding(5.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.offbar_landing),
                            contentDescription = null,
                            Modifier
                                .padding(5.dp)

                        )
                        Image(
                            painter = painterResource(id = R.drawable.offbar_landing),
                            contentDescription = null,
                            Modifier
                                .padding(5.dp)
                        )
                    }
                    Spacer(modifier.height(50.dp)
                    )
                }
            }
        }
    }
}


