package com.example.aqua_care.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.cardPremium
import com.example.aqua_care.Data.moduleCard
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.outlinetext
import com.example.aqua_care.Data.premiummoduleCard
import com.example.aqua_care.Data.switch
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun aquaModul(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text = remember { mutableStateOf("") }
    val selectedItem = remember { mutableStateOf(1) }
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier
                    .fillMaxWidth()
                    .background(Color(0xFF246DBB))
                    .padding(start = 15.dp, end = 15.dp)
                    .height(83.dp)
            ){
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .fillMaxWidth()
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
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_logonavbar),
                        contentDescription = null,
                        modifier.size(44.dp, 52.dp)
                    )
                }
            }
            Spacer(modifier.height(11.dp)
            )
            switch(onItemclickedFirstBox = {
                                           selectedItem.value = 1
            }, onItemclickedSecondBox = {
                selectedItem.value = 2
            })
            Spacer(modifier.height(12.dp)
            )
            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_search),
                        contentDescription = null,
                        modifier
                            .size(23.dp)
                    )
                },
                modifier = modifier
                    .size(305.dp, 42.dp),
                shape = RoundedCornerShape(20.dp),
                placeholder = {
                    opensanstext(
                        text = "Cari modul atau video pembelajaran",
                        size = 8.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF969696)
                    )
                }
            )
            when (selectedItem.value) {
                1 -> owned(navController = navController)
                2 -> notowned(navController = navController)
                else -> Unit
            }
        }
    }
}

@Composable
fun owned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
    ){
        cardPremium {
            navController.navigate(navScreen.premiumCategory.route)
        }
        Spacer(modifier.height(32.dp)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
        ){
            opensanstext(
                text = "Modul yang dimilki (2)",
                size = 13.sp,
                fontFamily = opensansbold,
                onItemclicked = {  },
                color = Color(0xFF272727)
            )
            Spacer(modifier.height(16.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
            ){
                moduleCard(
                    text = "2.5 jam 2 video",
                    title = "Kolam Udang Vaname Jenis, \n" +
                            "Sistem, dan Kapasitas Padat \n" +
                            "Tebar",
                    name = "Rico Lonewolf",
                    description = "Video ini memudahkan petambak udang untuk \n" +
                            "mengetahui lebih lanjut mengenai pertamb...",
                    image = R.drawable.image_example,
                    profilepic = R.drawable.alex_ganten,
                ){
                    navController.navigate(navScreen.detailModulowned.route)
                }
                Spacer(
                    modifier.height(8.dp)
                )
                moduleCard(
                    text = "27 Menit 3 Video",
                    title = "Jaga Kualitas Air Kolam Ikan \n" +
                            "Lele dengan Cara Berikut!",
                    name = "Rico Lonewolf",
                    description = "Video ini memudahkan petambak lele untuk \n" +
                            "mengetahui lebih lanjut mengenai pertamb...",
                    profilepic = R.drawable.alex_ganten,
                    image = R.drawable.image_example_2,
                ){
                    navController.navigate(navScreen.detailModulowned.route)
                }
            }
        }
    }
}


@Composable
fun notowned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ){
            Image(
                painter = painterResource(id = R.drawable.ohowwe),
                contentDescription = null
            )
            Spacer(modifier.width(10.dp))
            outlinetext(
                color = Color(0xFF246DBB),
                text = "Semua",
                textcolor = Color(0xFF246DBB)
            )
            Spacer(modifier.width(10.dp))
            outlinetext(
                color = Color(0xFFB2B2B2),
                text = "Manajemen",
                textcolor = Color(0xFFB2B2B2)
            )
            Spacer(modifier.width(10.dp))
            outlinetext(
                color = Color(0xFFB2B2B2),
                text = "Ikan",
                textcolor = Color(0xFFB2B2B2)
            )
            Spacer(modifier.width(10.dp))
            outlinetext(
                color = Color(0xFFB2B2B2),
                text = "Perawatan",
                textcolor = Color(0xFFB2B2B2)
            )
            Spacer(modifier.width(10.dp))
            outlinetext(
                color = Color(0xFFB2B2B2),
                text = "Penjualan",
                textcolor = Color(0xFFB2B2B2)
            )
        }
        Spacer(modifier.height(15.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ){
            premiummoduleCard(
                text = "1 Jam 2 Video",
                title = "Cara Budidaya Lele Sistem RAS\n" +
                        "yang Produktif!",
                name = "Luthfy Thedarkness",
                description = "Video ini memudahkan petambak lele untuk \n" +
                        "mengetahui lebih lanjut mengenai pertamb...",
                image = R.drawable.premiumimage_1,
                profilepic = R.drawable.upiw
            ){
                navController.navigate(navScreen.detailmodulnotOwned.route)
            }
            Spacer(modifier.height(15.dp)
            )
            premiummoduleCard(
                text = "1 Jam 2 Video",
                title = "Cara Memulai Usaha Jual Ikan\n" +
                        " Segar dari Nol!",
                name = "Luthfy Thedarkness",
                description = "Modul ini membantu para pembudidaya dalam\n" +
                        "menjual ikan yang sudah di panen agar tidak ...",
                image = R.drawable.premiumimage_2,
                profilepic = R.drawable.upiw
            ){
                navController.navigate(navScreen.detailmodulnotOwned.route)
            }
            Spacer(modifier.height(15.dp)
            )
            premiummoduleCard(
                text = "1 Jam 2 Video",
                title = "Ini Dia Hal yang Harus Diperhatikan \n" +
                        "pada Kolam Udang!",
                name = "Luthfy Thedarkness",
                description = "Modul ini membantu para pembudidaya dalam\n" +
                        "menjual ikan yang sudah di panen agar tidak ...",
                image = R.drawable.premiumimage_3,
                profilepic = R.drawable.upiw
            ){
                navController.navigate(navScreen.detailmodulnotOwned.route)
            }
            Spacer(modifier.height(15.dp)
            )
            moduleCard(
                text = "2.5 jam 2 video",
                title = "Kolam Udang Vaname Jenis, \n" +
                        "Sistem, dan Kapasitas Padat \n" +
                        "Tebar",
                name = "Rico Lonewolf",
                description = "Video ini memudahkan petambak udang untuk \n" +
                        "mengetahui lebih lanjut mengenai pertamb...",
                image = R.drawable.image_example,
                profilepic = R.drawable.alex_ganten,
            ){

            }
            Spacer(
                modifier.height(15.dp)
            )
            moduleCard(
                text = "27 Menit 3 Video",
                title = "Jaga Kualitas Air Kolam Ikan \n" +
                        "Lele dengan Cara Berikut!",
                name = "Rico Lonewolf",
                description = "Video ini memudahkan petambak lele untuk \n" +
                        "mengetahui lebih lanjut mengenai pertamb...",
                profilepic = R.drawable.alex_ganten,
                image = R.drawable.image_example_2
            ){

            }
        }
    }
}