package com.example.aqua_care.ui.Presentation.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.berita
import com.example.aqua_care.Data.beritaData
import com.example.aqua_care.Data.opensansextrabold
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Data.topdetailBar
import com.example.aqua_care.Navigation.navScreen

@Composable
fun detailBerita(
    modifier: Modifier = Modifier,
    navController: NavController,
    newBeritaList : List<berita>
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
            topdetailBar(navController = navController, onItemclicked = {
                navController.navigate(navScreen.homePage.route)
            })
            Column(
                modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                newBeritaList.forEach { berita ->


                    opensanstext(
                        text = berita.title,
                        size = 16.sp,
                        fontFamily = opensansextrabold,
                        onItemclicked = { },
                        color = Color(0xFF424373)
                    )
                    Spacer(
                        modifier.height(31.dp)
                    )
                    Image(
                        painter = painterResource(id = berita.image),
                        contentDescription = null,
                        modifier
                            .fillMaxWidth()
                    )
                    Spacer(
                        modifier.height(15.dp)
                    )
                    opensanstext(
                        text = berita.description,
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        onItemclicked = { },
                        color = Color(0xFF111111)
                    )
                    Spacer(modifier = modifier.height(30.dp))

                    opensanstext(
                        text = berita.website,
                        size = 12.sp,
                        fontFamily = opensanssemibold,
                        color = Color(0xFF111111)
                    )
                }
            }
        }
    }
}

@Composable
fun beritaConnect(
    modifier: Modifier = Modifier,
    beritaId : Int?,
    navController: NavController
) {
    val newBeritaList = beritaData.beritaList.filter { berita ->
        beritaId == berita.id
    }
    Column(
    ){
        if (beritaId != null && newBeritaList.isNotEmpty()){
            detailBerita(navController = navController, newBeritaList = newBeritaList)
        } else {
            Text(text = "Berita Tidak Ditemukan")
        }
    }
}

