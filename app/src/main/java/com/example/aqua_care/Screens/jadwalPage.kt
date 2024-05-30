package com.example.aqua_care.Screens

import android.widget.Space
import androidx.compose.foundation.background
import androidx.lifecycle.viewmodel.compose.viewModel
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen


class ScheduleViewModel : ViewModel() {
    var isFeedEnabled by mutableStateOf(false)
    var isAntibioticEnabled by mutableStateOf(false)
    var isPhControlEnabled by mutableStateOf(false)
}
@Composable
fun jadwalPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: ScheduleViewModel = viewModel()
){
    var isFeedEnabled by remember { mutableStateOf(viewModel.isFeedEnabled) }
    var isAntibioticEnabled by remember { mutableStateOf(viewModel.isAntibioticEnabled) }
    var isPhControlEnabled by remember { mutableStateOf(viewModel.isPhControlEnabled) }

    LaunchedEffect(viewModel) {
        snapshotFlow { viewModel.isFeedEnabled }
            .collect { newValue ->
                isFeedEnabled = newValue
            }
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .height(93.dp)
                .background(Color(0xFF246DBB))
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp, top = 10.dp)
            ){
                opensanstext(
                    text = "Pengingat Saya",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color.White
                )
            }
        }
        Spacer(modifier.height(7.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .size(323.dp, 92.dp)
                    .clickable {
                        navController.navigate(navScreen.detailJadwal.route + "/$isFeedEnabled")
                    }
            ){
                Column (
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ){
                    opensanstext(
                        text = "Pemberian Pakan",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = "Status Pemberian Pakan: ${if (isFeedEnabled) "Aktif" else "Tidak Aktif"}",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF969696)
                    )
                    opensanstext(
                        text = "08.00 - 12.00 - 16.00",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = "Setiap Hari",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
            Spacer(modifier.height(16.dp)
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .size(323.dp, 92.dp)
                    .clickable {
                        navController.navigate(navScreen.detailJadwal.route + "/$isFeedEnabled")
                    }
            ){
                Column (
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ){
                    opensanstext(
                        text = "Pemberian Antibiotik",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = "Status Pemberian Pakan: ${if (isFeedEnabled) "Aktif" else "Tidak Aktif"}",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF969696)
                    )
                    opensanstext(
                        text = "Setiap 30 Hari sekali",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
            Spacer(modifier.height(16.dp)
            )
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .size(323.dp, 92.dp)
                    .clickable {
                        navController.navigate(navScreen.detailJadwal.route + "/$isFeedEnabled")
                    }
            ){
                Column (
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(start = 15.dp)
                ){
                    opensanstext(
                        text = "Kontrol pH Air",
                        size = 14.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    opensanstext(
                        text = "Status Pemberian Pakan: ${if (isFeedEnabled) "Aktif" else "Tidak Aktif"}",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF969696)
                    )
                    opensanstext(
                        text = "Setiap 1 Minggu sekali",
                        size = 10.sp,
                        fontFamily = opensansregular,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                }
            }
        }
    }
}

