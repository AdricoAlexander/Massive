package com.example.aqua_care.Screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aqua_care.Data.notif
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun notification(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            modifier
                .fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFF246DBB))
                    .height(83.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_backarrow),
                        contentDescription = null,
                        modifier
                            .size(44.dp, 52.dp)
                            .clickable {
                                navController.navigate(navScreen.homePage.route)
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_logonavbar),
                        contentDescription = null,
                        modifier.size(44.dp, 52.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_grid),
                        contentDescription = null,
                        modifier.size(44.dp, 52.dp)
                    )
                }
            }
            Spacer(modifier.height(25.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
            ){
                notif(
                    title = "Premium",
                    description = "Selamat! Anda dapat menikmati akses premium!....",
                    image1 = R.drawable.premium_1,
                    image2 = R.drawable.level_1
                )
                Spacer(modifier.height(14.dp)
                )
                notif(
                    title = "Pengingat",
                    description = "Anda harus memberi antibiotik pada pukul 08.00",
                    image1 = R.drawable.premium_2,
                    image2 = R.drawable.level_1
                )
            }
        }
    }
}
