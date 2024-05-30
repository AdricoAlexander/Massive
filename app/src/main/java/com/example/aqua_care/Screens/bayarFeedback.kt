package com.example.aqua_care.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R


@Composable
fun bayarFeedback(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        modifier
            .fillMaxSize()
            .background(Color(0xFF246DBB))
    ){
        Box(
            modifier
                .fillMaxSize()
                .padding(horizontal = 44.dp, vertical = 63.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_whitehome),
                contentDescription = null,
                modifier = modifier
                    .size(25.dp)
                    .clickable {
                        navController.navigate(navScreen.homePage.route)
                    }
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.verified_icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(152.dp)
                )
                Spacer(modifier = modifier.height(47.dp)
                )
                opensanstext(
                    text = "Pembayaran Berhasil",
                    size = 18.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color.White
                )
                Spacer(modifier = modifier.height(31.dp)
                )
                opensanstext(
                    text = "Selamat! Anda sekarang memiliki akses eksklusif ke 100 modul terkini, 100 video edukasi, dan bonus konsultasi gratis 3x!",
                    size = 12.sp,
                    fontFamily = opensansregular,
                    onItemclicked = {  },
                    color = Color.White
                )
                Spacer(modifier = modifier.height(31.dp)
                )
                opensanstext(
                    text = "Mulailah petualangan Anda menuju keahlian dalam dunia budidaya ikan!",
                    size = 16.sp,
                    fontFamily = opensanssemibold,
                    onItemclicked = {  },
                    color = Color.White
                )
            }
        }
    }
}


