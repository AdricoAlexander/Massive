package com.example.aqua_care.ui.Presentation.Onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun landingPage_3(
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
            Spacer(modifier.height(126.dp)
            )
            opensanstext(
                text = "Mudahkan budidaya",
                size = 20.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            opensanstext(
                text = "dengan fitur perencanaan",
                size = 20.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            Spacer(modifier.height(37.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.landing_image_3),
                contentDescription = null,
            )
            Spacer(modifier.height(37.dp)
            )
            opensanstext(
                text = "Kamu tidak perlu khawatir",
                size = 16.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            opensanstext(
                text = "kelupaan untuk pemberian pakan,",
                size = 16.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            opensanstext(
                text = "penggantian air, dan antibiotik lagi.",
                size = 16.sp,
                fontFamily = opensansbold,
                color = Color(0xFF272727),
                onItemclicked = null
            )
            Spacer(modifier.height(50.dp)
            )
            aquaButton(
                color = Color(0xFF246DBB),
                width = 264.dp,
                height = 35.dp,
                text = "Mulai Sekarang",
                fontFamily = opensansbold,
                textColor = Color.White
            ){
                navController.navigate(navScreen.signupPage.route)
            }
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
                        horizontalArrangement = Arrangement.Center,
                        modifier = modifier
                            .fillMaxWidth()
                    ){
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
                        Image(
                            painter = painterResource(id = R.drawable.onbar_landing),
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