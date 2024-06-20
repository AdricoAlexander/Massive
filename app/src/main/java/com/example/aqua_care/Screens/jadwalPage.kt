package com.example.aqua_care.Screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.AlarmManager.AlarmList
import com.example.aqua_care.AlarmManager.AlarmList.alarmList
import com.example.aqua_care.AlarmManager.AlarmType
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.AlarmRepository
import com.example.aqua_care.Navigation.navScreen


@Composable
fun JadwalPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    alarmRepository: AlarmRepository
) {

    val alarm = remember { AlarmList.alarmList }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .height(93.dp)
                .background(Color(0xFF246DBB))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(20.dp, top = 10.dp)
            ) {
                Text(
                    text = "Pengingat Saya",
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
        Spacer(modifier.height(7.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            LazyColumn {
                items(
                    items = alarm,
                    key = { it.id }
                ) { alarm ->
                    val alarmStatus by alarmRepository.getAlarmStatus(alarm.id).collectAsState(
                        initial = alarm.status
                    )
                    AquaAlarmLayout(
                        alarmType = alarm.copy(status = alarmStatus),
                        onItemClicked = { id ->
                            navController.navigate(navScreen.detailJadwal.route + "/$id")
                        }
                    )
                }
            }
        }
    }
}




@Composable
fun AquaAlarmLayout(
    modifier: Modifier = Modifier,
    alarmType: AlarmType,
    onItemClicked: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp)
            .clickable {
                onItemClicked(alarmType.id)
            },
        colors = CardDefaults.cardColors(Color(0xFFDFE0F3)),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.elevatedCardElevation(1.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            opensanstext(
                text = alarmType.title,
                size = 14.sp,
                fontFamily = opensanssemibold,
                onItemclicked = {},
                color = Color(0xFF272727)
            )
            opensanstext(
                text = if (alarmType.status) {
                    "Aktif"
                } else {
                    "Tidak Aktif"
                },
                size = 12.sp,
                fontFamily = opensansregular,
                onItemclicked = {},
                color = Color(0xFF272727)
            )
            opensanstext(
                text = alarmType.time ?: "",
                size = 12.sp,
                fontFamily = opensansregular,
                onItemclicked = {},
                color = Color(0xFF272727)
            )
            opensanstext(
                text = alarmType.date ?: "",
                size = 12.sp,
                fontFamily = opensansregular,
                onItemclicked = {},
                color = Color(0xFF272727)
            )
        }
    }
}
