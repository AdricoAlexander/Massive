package com.example.aqua_care.Screens

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.cardPremium
import com.example.aqua_care.Data.cardType
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R


@Composable
fun detailModulowned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    var isClicked by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ){
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier
                    .fillMaxWidth()
                    .height(93.dp)
                    .background(Color(0xFF246DBB))
                    .padding(20.dp)
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
                        modifier = modifier
                            .size(29.dp)
                            .clickable {
                                if (!isClicked) {
                                    navController.navigate(navScreen.aquaModul.route)
                                } else {
                                    isClicked = false
                                }
                            }
                    )
                    opensanstext(
                        text = "Detail Modul",
                        size = 18.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_grid),
                        contentDescription = null,
                        modifier = modifier
                            .size(29.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.video_example),
                    contentDescription = null,
                    modifier = modifier
                        .size(304.dp, 161.dp)
                )
                Spacer(modifier.height(10.dp)
                )
                opensanstext(
                    text = "Jaga Kualitas Air Kolam Ikan Lele dengan Cara\n" +
                            "Berikut !",
                    size = 13.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Spacer(modifier.height(10.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    cardType(
                        image = painterResource(id = R.drawable.icon_management),
                        text = "Manajemen"
                    )
                    Spacer(modifier.width(5.dp)
                    )
                    cardType(
                        image = painterResource(id = R.drawable.icon_water),
                        text = "Perawatan"
                    )
                }
                Spacer(modifier.height(10.dp)
                )
                if (!isClicked) {
                    Column(
                    ) {

                        opensanstext(
                            text = "Modul ini membantu para pembudidaya dalam \n" +
                                    "Menjaga kualitas Air kolam ikan Lele agar panen\n" +
                                    "yang dihasilkan lebih berkualitas !",
                            size = 11.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF6B6B6B)
                        )
                        Spacer(
                            modifier.height(10.dp)
                        )
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFFACACAC)),
                            modifier = modifier
                                .shadow(5.dp)
                                .size(226.dp, 36.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(7.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.icon_book),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(23.dp)
                                )
                                Spacer(
                                    modifier.width(7.dp)
                                )
                                opensanstext(
                                    text = "Modul Ini Gratis !",
                                    size = 12.sp,
                                    fontFamily = opensanssemibold,
                                    onItemclicked = { },
                                    color = Color(0xFF246DBB)
                                )
                            }
                        }
                        Spacer(
                            modifier.height(14.dp)
                        )
                        opensanstext(
                            text = "Isi Modul",
                            size = 13.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                        Spacer(
                            modifier.height(4.dp)
                        )
                        opensanstext(
                            text = "27 Menit  *  3 Video",
                            size = 8.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF828282)
                        )
                        Spacer(
                            modifier.height(9.dp)
                        )
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFFACACAC)),
                            modifier = modifier
                                .fillMaxWidth()
                                .height(39.dp)
                                .clickable {
                                    isClicked = true
                                }
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(11.dp)
                            ) {
                                opensanstext(
                                    text = "Cara menangani limbah",
                                    size = 11.sp,
                                    fontFamily = opensansextrabold,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = modifier
                                        .width(60.dp)
                                ) {
                                    opensanstext(
                                        text = "1 Video",
                                        size = 8.sp,
                                        fontFamily = opensansbold,
                                        onItemclicked = { },
                                        color = Color(0xFF828282)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.forward_arrow),
                                        contentDescription = null,
                                        modifier = modifier
                                            .size(17.dp)
                                    )
                                }
                            }
                        }
                        Spacer(
                            modifier.height(9.dp)
                        )
                        Card(
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color(0xFFACACAC)),
                            modifier = modifier
                                .fillMaxWidth()
                                .height(39.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .fillMaxSize()
                                    .padding(11.dp)
                            ) {
                                opensanstext(
                                    text = "Tutorial Sirkulasi Air Di Pertanian",
                                    size = 11.sp,
                                    fontFamily = opensansextrabold,
                                    onItemclicked = { },
                                    color = Color(0xFF272727)
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = modifier
                                        .width(60.dp)
                                ) {
                                    opensanstext(
                                        text = "2 Video",
                                        size = 8.sp,
                                        fontFamily = opensansbold,
                                        onItemclicked = { },
                                        color = Color(0xFF828282)
                                    )
                                    Image(
                                        painter = painterResource(id = R.drawable.forward_arrow),
                                        contentDescription = null,
                                        modifier = modifier
                                            .size(17.dp)
                                    )
                                }
                            }
                        }
                    }
                } else {
                    detailvideo()
                }
            }
        }
    }
}


@Composable
fun detailvideo(
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
    ){
        opensanstext(
            text = "Cara Menangani Limbah !",
            size = 20.sp,
            fontFamily = opensansextrabold,
            onItemclicked = {  }
            , color = Color(0xFF515151)
        )
        Spacer(modifier.height(14.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFACACAC))
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(11.dp)
            ){
                opensanstext(
                    text = "1. Cara menangani Limbah dengan peng...",
                    size = 11.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Image(
                    painter = painterResource(id = R.drawable.play_icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(25.dp)
                )
            }
        }
    }
}


@Composable
fun detailmodulnotOwned(
    modifier: Modifier = Modifier,
    navController: NavController
){
    var isClicked by remember { mutableStateOf(false) }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier
                    .fillMaxWidth()
                    .height(93.dp)
                    .background(Color(0xFF246DBB))
                    .padding(20.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_backarrow),
                        contentDescription = null,
                        modifier = modifier
                            .size(29.dp)
                            .clickable {
                                if (!isClicked){
                                    navController.navigate(navScreen.aquaModul.route)
                                } else {
                                    isClicked = false
                                }
                            }
                    )
                    opensanstext(
                        text = "Detail Modul",
                        size = 18.sp,
                        fontFamily = opensansbold,
                        onItemclicked = { },
                        color = Color.White
                    )
                    Image(
                        painter = painterResource(id = R.drawable.icon_grid),
                        contentDescription = null,
                        modifier = modifier
                            .size(29.dp)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = modifier
                    .fillMaxSize()
                    .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.video_example_2),
                    contentDescription = null,
                    modifier = modifier
                        .size(304.dp, 161.dp)
                )
                Spacer(
                    modifier.height(10.dp)
                )
                opensanstext(
                    text = "Cara Memulai Usaha Jual Ikan Segar dari Nol!",
                    size = 13.sp,
                    fontFamily = opensansbold,
                    onItemclicked = { },
                    color = Color(0xFF272727)
                )
                Spacer(
                    modifier.height(10.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = modifier
                        .fillMaxWidth()
                ){
                    cardType(
                        image = painterResource(id = R.drawable.icon_management),
                        text = "Manajemen"
                    )
                    Spacer(modifier.width(5.dp)
                    )
                    cardType(
                        image = painterResource(id = R.drawable.market_icon),
                        text = "Penjualan"
                    )
                }
                Spacer(
                    modifier.height(10.dp)
                )
                if (!isClicked) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = modifier
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.premium_1),
                            contentDescription = null,
                            modifier = modifier
                                .size(18.dp)
                        )
                        Spacer(
                            modifier.width(7.dp)
                        )
                        opensanstext(
                            text = "Premium",
                            size = 14.sp,
                            fontFamily = opensansregular,
                            onItemclicked = { },
                            color = Color(0xFF272727)
                        )
                    }
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = "Modul ini membantu para pembudidaya dalam menjual\n" +
                                "ikan yang sudah dipanen agar tidak mengalami kerugian\n" +
                                "ketika dijual.",
                        size = 11.sp,
                        fontFamily = opensansbold,
                        onItemclicked = { },
                        color = Color(0xFF6B6B6B)
                    )
                    Spacer(
                        modifier.height(18.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFACACAC)),
                        modifier = modifier
                            .shadow(5.dp)
                            .size(238.dp, 42.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_book),
                                contentDescription = null,
                                modifier = modifier
                                    .size(23.dp)
                            )
                            Spacer(
                                modifier.width(7.dp)
                            )
                            opensanstext(
                                text = "Modul Premium",
                                size = 12.sp,
                                fontFamily = opensanssemibold,
                                onItemclicked = { },
                                color = Color(0xFF246DBB)
                            )
                            Spacer(
                                modifier.width(7.dp)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.premium_1),
                                contentDescription = null
                            )
                        }
                    }
                    Spacer(
                        modifier.height(14.dp)
                    )
                    opensanstext(
                        text = "Isi Modul",
                        size = 13.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {},
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = "2.5 Jam  *  9 Video",
                        size = 8.sp,
                        fontFamily = opensansbold,
                        onItemclicked = { },
                        color = Color(0xFF828282)
                    )
                    Spacer(
                        modifier.height(14.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFACACAC)),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(39.dp)
                            .clickable {
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(11.dp)
                        ) {
                            opensanstext(
                                text = "Lokasi Berjualan",
                                size = 11.sp,
                                fontFamily = opensansextrabold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .width(60.dp)
                            ) {
                                opensanstext(
                                    text = "3 Video",
                                    size = 8.sp,
                                    fontFamily = opensansbold,
                                    onItemclicked = { },
                                    color = Color(0xFF828282)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.forward_arrow),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(17.dp)
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier.height(9.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFACACAC)),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(39.dp)
                            .clickable {
                                isClicked = true
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(11.dp)
                        ) {
                            opensanstext(
                                text = "Pengetahuan dalam Berbisnis Ikan",
                                size = 11.sp,
                                fontFamily = opensansextrabold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .width(60.dp)
                            ) {
                                opensanstext(
                                    text = "3 Video",
                                    size = 8.sp,
                                    fontFamily = opensansbold,
                                    onItemclicked = { },
                                    color = Color(0xFF828282)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.forward_arrow),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(17.dp)
                                )
                            }
                        }
                    }
                    Spacer(
                        modifier.height(9.dp)
                    )
                    Card(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFACACAC)),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(39.dp)
                            .clickable {
                            }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = modifier
                                .fillMaxSize()
                                .padding(11.dp)
                        ) {
                            opensanstext(
                                text = "Cerita mengenai penjualan ikan",
                                size = 11.sp,
                                fontFamily = opensansextrabold,
                                onItemclicked = { },
                                color = Color(0xFF272727)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = modifier
                                    .width(60.dp)
                            ) {
                                opensanstext(
                                    text = "3 Video",
                                    size = 8.sp,
                                    fontFamily = opensansbold,
                                    onItemclicked = { },
                                    color = Color(0xFF828282)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.forward_arrow),
                                    contentDescription = null,
                                    modifier = modifier
                                        .size(17.dp)
                                )
                            }
                        }
                    }
                } else {
                    detailvideopremium(navController = navController)
                }
            }
        }
    }
}

@Composable
fun detailvideopremium(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
    ){
        opensanstext(
            text = "Pengetahuan dalam Berbisnis Ikan",
            size = 20.sp,
            fontFamily = opensansextrabold,
            onItemclicked = {  }
            , color = Color(0xFF515151)
        )
        Spacer(modifier.height(14.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFACACAC))
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(11.dp)
            ){
                opensanstext(
                    text = "1. Cara menangani Limbah dengan peng...",
                    size = 11.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Image(
                    painter = painterResource(id = R.drawable.blacklock_icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(25.dp)
                )
            }
        }
        Spacer(modifier.height(9.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFACACAC))
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(11.dp)
            ){
                opensanstext(
                    text = "2. Bisnis Ikan Menyehatkan",
                    size = 11.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Image(
                    painter = painterResource(id = R.drawable.blacklock_icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(25.dp)
                )
            }

        }
        Spacer(modifier.height(9.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFFACACAC))
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxSize()
                    .padding(11.dp)
            ){
                opensanstext(
                    text = "3. Nasib Budidaya ikan di Indonesia",
                    size = 11.sp,
                    fontFamily = opensansextrabold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
                Image(
                    painter = painterResource(id = R.drawable.blacklock_icon),
                    contentDescription = null,
                    modifier = modifier
                        .size(25.dp)
                )
            }
        }
        Spacer(modifier.height(18.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
        ){
            cardPremium {
                navController.navigate(navScreen.premiumCategory.route)
            }
        }
    }
}
