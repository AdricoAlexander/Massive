package com.example.aqua_care.ui.Presentation.Home

import BeritaViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Berita.Model.Post
import com.example.aqua_care.Data.MainTopBar
import com.example.aqua_care.Data.beritaLayout
import com.example.aqua_care.Data.homeNavigator
import com.example.aqua_care.Data.modulData
import com.example.aqua_care.Data.modulLayout
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R


@Composable
fun homePage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel : BeritaViewModel
) {

    val loading by viewModel.loading.observeAsState(false)
    val error by viewModel.error.observeAsState()
    val news by viewModel.latestNews.observeAsState(emptyList())

    Column(
        modifier
            .fillMaxSize()
    ) {
        MainTopBar(navController = navController)
        Spacer(
            modifier.height(14.dp)
        )
        LazyRow(
        ) {
            items(
                items = modulData.modulList,
                itemContent = {
                    modulLayout(modul = it)
                }
            )
        }
        Image(
            painter = painterResource(id = R.drawable.icon_bit),
            contentDescription = null,
            modifier
                .padding(start = 20.dp, top = 7.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(top = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                homeNavigator(
                    onItemclicked = {
                        navController.navigate(navScreen.aquaModul.route)
                    },
                    text = "AquaModul",
                    image = R.drawable.icon_modul,
                )
                homeNavigator(
                    onItemclicked = {
                        navController.navigate(navScreen.jadwalPage.route)
                    },
                    text = "AquaSentry",
                    image = R.drawable.icon_sentry,
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
            ) {
                homeNavigator(
                    onItemclicked = {
                        navController.navigate(navScreen.scanPage.route)
                    },
                    text = "AquaScan",
                    image = R.drawable.icon_scan,
                )
                homeNavigator(
                    onItemclicked = {
                        navController.navigate(navScreen.chatbotPage.route)
                    },
                    text = "AquaBot",
                    image = R.drawable.icon_rowbott,
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp, end = 30.dp, bottom = 10.dp)
        ) {
            opensanstext(
                text = "Berita",
                size = 16.sp,
                fontFamily = opensansextrabold,
                onItemclicked = { },
                color = Color(0xFF272727)
            )
        }
        if (loading){
            CircularProgressIndicator()
        } else {
            Column {
                error?.let { 
                    Text(text = it)
                }
            }
            NewsItem(news = news)
        }
    }
}

@Composable
fun NewsItem(
    modifier: Modifier = Modifier,
    news : List<Post>
) {
    LazyRow(
        modifier
            .padding(10.dp)
    ){
        items(news) {
            beritaLayout(post = it)
        }
    }
}

