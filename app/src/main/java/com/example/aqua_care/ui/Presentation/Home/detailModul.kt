package com.example.aqua_care.ui.Presentation.Home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController
import com.example.aqua_care.Data.Modul
import com.example.aqua_care.Data.PremiumModul
import com.example.aqua_care.Data.Video
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.aquamodulData
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
fun ModulConnect(
    modulId : Int?,
    navController: NavController
) {
    val newModulList = aquamodulData.modulList.filter {
        it.id == modulId
    }
    Column {
        if (modulId != null && newModulList.isNotEmpty()){
            detailModulowned(navController = navController, newModulList = newModulList)
        } else {
            Text(text = "Modul Tidak Ditemukan")
        }
    }

}

@Composable
fun PremiumModulConnect(
    modifier: Modifier = Modifier,
    premModulId : Int ?,
    navController: NavController
) {
    val newPremiumModulList = aquamodulData.premiumModulList.filter {
        it.id == premModulId
    }
    Column {
        if (premModulId != null && newPremiumModulList.isNotEmpty()){
            detailmodulnotOwned(navController = navController, newPremiumModulList = newPremiumModulList)
        } else {
            Text(text = "Modul Tidak Ditemukan")
        }
    }
}

@Composable
fun detailModulowned(
    modifier: Modifier = Modifier,
    navController: NavController,
    newModulList : List<Modul>
) {

    val context = LocalContext.current
    var isClicked by remember { mutableStateOf(false) }
    val exoPlayer = ExoPlayer.Builder(context).build()
    var selectedVideo by remember { mutableStateOf<Video?>(null) }



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
            newModulList.forEach { modul ->
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
                ) {
                    Spacer(
                        modifier.height(10.dp)
                    )
                    opensanstext(
                        text = modul.title,
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
                    ) {
                        cardType(
                            image = painterResource(id = R.drawable.icon_management),
                            text = "Manajemen"
                        )
                        Spacer(
                            modifier.width(5.dp)
                        )
                        cardType(
                            image = painterResource(id = R.drawable.icon_water),
                            text = "Perawatan"
                        )
                    }
                    Spacer(
                        modifier.height(10.dp)
                    )
                    Column(
                    ) {

                        opensanstext(
                            text = modul.description,
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
                            text = modul.videoamount,
                            size = 8.sp,
                            fontFamily = opensansbold,
                            onItemclicked = { },
                            color = Color(0xFF828282)
                        )
                        Spacer(
                            modifier.height(9.dp)
                        )

                        Spacer(
                            modifier.height(9.dp)
                        )

                        LazyColumn(
                            modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            items(modul.video) { video ->
                                VideoLayout(video = video, onClick = { onClick ->
                                    selectedVideo = onClick
                                    isClicked = true
                                })
                            }
                        }
                    }
                }
            }
        }
    }
    if (isClicked && selectedVideo != null){
        AlertDialog(
            onDismissRequest = {
                exoPlayer.stop()
                isClicked = false
            },
            title = {
                opensanstext(
                    text = selectedVideo!!.title,
                    size = 14.sp,
                    fontFamily = opensanssemibold,
                    color = Color(0xFF272727)
                )
            },
            text = {
                AndroidView(factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                        exoPlayer.setMediaItem(MediaItem.fromUri(selectedVideo!!.link))
                        exoPlayer.prepare()
                        exoPlayer.playWhenReady
                    }
                })
            },
            confirmButton = {
                aquaButton(
                    color = Color.White,
                    width = 150.dp,
                    height = 50.dp,
                    textColor = Color(0xFF246DBB),
                    text = "Close",
                    fontFamily = opensansregular
                ) {
                    exoPlayer.stop()
                    isClicked = false

                }
            })
    }
}



@Composable
fun detailmodulnotOwned(
    modifier: Modifier = Modifier,
    navController: NavController,
    newPremiumModulList : List<PremiumModul>
){
    val context = LocalContext.current
    var isClicked by remember { mutableStateOf(false) }
    val exoPlayer = ExoPlayer.Builder(context).build()
    var selectedVideo by remember { mutableStateOf<Video?>(null) }
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
                newPremiumModulList.forEach { premiumModul ->

                    opensanstext(
                        text = premiumModul.title,
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
                    ) {
                        cardType(
                            image = painterResource(id = R.drawable.icon_management),
                            text = "Manajemen"
                        )
                        Spacer(
                            modifier.width(5.dp)
                        )
                        cardType(
                            image = painterResource(id = R.drawable.market_icon),
                            text = "Penjualan"
                        )
                    }
                    Spacer(
                        modifier.height(10.dp)
                    )
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
                        text = premiumModul.description,
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
                        text = premiumModul.videoamount,
                        size = 8.sp,
                        fontFamily = opensansbold,
                        onItemclicked = { },
                        color = Color(0xFF828282)
                    )
                    Spacer(
                        modifier.height(14.dp)
                    )
                    LazyColumn(
                        modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        items(premiumModul.video){ video ->
                            PremiumVideoLayout(video = video) {
                                selectedVideo = it
                                isClicked = true
                            }
                        }
                    }
                }
            }
        }
    }
    if (isClicked && selectedVideo != null){
        AlertDialog(
            onDismissRequest = {
                exoPlayer.stop()
                isClicked = false
            },
            title = {
                opensanstext(
                    text = selectedVideo!!.title,
                    size = 14.sp,
                    fontFamily = opensanssemibold,
                    color = Color(0xFF272727)
                )
            },
            text = {
                AndroidView(factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                        exoPlayer.setMediaItem(MediaItem.fromUri(selectedVideo!!.link))
                        exoPlayer.prepare()
                        exoPlayer.playWhenReady
                    }
                })
            },
            confirmButton = {
                aquaButton(
                    color = Color.White,
                    width = 150.dp,
                    height = 50.dp,
                    textColor = Color(0xFF246DBB),
                    text = "Close",
                    fontFamily = opensansregular
                ) {
                    exoPlayer.stop()
                    isClicked = false

                }
            })
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
