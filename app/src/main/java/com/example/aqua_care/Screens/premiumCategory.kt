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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.paymentCard
import com.example.aqua_care.Data.premiumData
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun premiumCategory(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val premiumList = remember { premiumData.premiumList }
    val previousBackStackEntry = navController.previousBackStackEntry
    val previousRoute = previousBackStackEntry?.destination?.route
    Column(
        modifier
            .fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .height(133.dp)
                .background(Color(0xFF246DBB))
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 29.dp, start = 14.dp, bottom = 14.dp, end = 14.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_backarrow),
                        contentDescription = null,
                        modifier
                            .size(29.dp)
                            .clickable {
                                if (previousRoute == navScreen.profilePage.route){
                                    navController.navigate(navScreen.profilePage.route)
                                } else {
                                    navController.navigate(navScreen.aquaModul.route)
                                }
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_logo2),
                        contentDescription = null,
                        modifier
                            .size(81.dp, 46.dp)
                    )
                    Spacer(modifier.width(30.dp))
                }
                Box(
                    contentAlignment = Alignment.BottomCenter,
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = modifier
                            .fillMaxSize()
                    ) {
                        opensanstext(
                            text = "Dapatkan akses premium ke modul-modul eksklusif",
                            size = 12.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color.White,
                        )
                        opensanstext(
                            text = "dan raih kesuksesan bersama!",
                            size = 12.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color.White,
                        )
                    }
                }
            }
        }
        Spacer(modifier.height(16.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ){
            LazyColumn{
                items(
                    items = premiumList, key = {it.id},
                    itemContent = {
                        paymentCard(premium = it) {itemId ->
                            navController.navigate(navScreen.paymentDetail.route + "/$itemId")
                        }
                    }
                )
            }
        }
    }
}
