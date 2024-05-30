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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R

@Composable
fun detailJadwal(
    modifier: Modifier = Modifier,
    navController: NavController,
    isFeedEnabled  : Boolean
){
    var checked by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = modifier
                .fillMaxWidth()
                .height(67.dp)
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth(0.7f)
                    .padding(14.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.icon_backarrow),
                    contentDescription = null,
                    modifier = modifier
                        .size(29.dp)
                        .clickable {
                            navController.navigate(navScreen.jadwalPage.route )
                        }
                )
                opensanstext(
                    text = "Pemberian Pakan",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {  },
                    color = Color(0xFF272727)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.topline) ,
            contentDescription = null,
            )
        Spacer(modifier.height(31.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .size(323.dp, 46.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ){
                    opensanstext(
                        text = "Aktifkan Pengingat",
                        size = 12.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {  },
                        color = Color(0xFF272727)
                    )
                    Switch(
                        checked = checked,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = Color(0xFF246DBB),
                            checkedThumbColor = Color(0xFFFFFFFF),
                            uncheckedTrackColor = Color(0xFF969696),
                            uncheckedThumbColor = Color(0xFFFFFFFF)
                        ),
                        modifier = modifier
                            .size(40.dp, 20.dp)
                    )
                }
            }
            Spacer(modifier.height(31.dp)
            )
            if (checked == true){
                ifchecked(viewModel = ScheduleViewModel())
            }
        }
    }
}


@Composable
fun ifchecked(
    modifier: Modifier = Modifier,
    viewModel: ScheduleViewModel

){
    var checked by remember { mutableStateOf(viewModel.isFeedEnabled) }
    var checked2  by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        opensanstext(
            text = "Tipe Notifikasi",
            size = 12.sp,
            fontFamily = opensansregular,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp)
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
        ){
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
                modifier = modifier
                    .size(317.dp, 48.dp)
                ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(5.dp,)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier
                            .width(127.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lonceng_icon),
                            contentDescription = null,
                            modifier = modifier
                                .size(23.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            opensanstext(
                                text = "Notifikasi",
                                size = 14.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color(0xFF272727)
                            )
                            opensanstext(
                                text = if(checked == true){
                                    "ON"
                                } else {
                                    "OFF"
                                },
                                size = 10.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color(0xFF3C3C3C)
                            )
                        }
                    }
                    Switch(
                        checked = checked ,
                        onCheckedChange = {
                            checked = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = Color(0xFF246DBB),
                            checkedThumbColor = Color(0xFFFFFFFF),
                            uncheckedTrackColor = Color(0xFF969696),
                            uncheckedThumbColor = Color(0xFFFFFFFF)
                        ),
                    )
                }
            }
            Spacer(modifier.height(1.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                modifier = modifier
                    .size(317.dp, 48.dp)
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(5.dp,)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier
                            .width(127.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.lonceng_icon),
                            contentDescription = null,
                            modifier = modifier
                                .size(23.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ){
                            opensanstext(
                                text = "Alarm",
                                size = 14.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color(0xFF272727)
                            )
                            opensanstext(
                                text = if(checked2 == true){
                                                          "ON"
                                                          } else {
                                                                 "OFF"
                                                                 },
                                size = 10.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {  },
                                color = Color(0xFF3C3C3C)
                            )
                        }
                    }
                    Switch(
                        checked = checked2,
                        onCheckedChange = {
                            checked2 = it
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = Color(0xFF246DBB),
                            checkedThumbColor = Color(0xFFFFFFFF),
                            uncheckedTrackColor = Color(0xFF969696),
                            uncheckedThumbColor = Color(0xFFFFFFFF)
                        ),
                    )
                }
            }
        }
    }
}

