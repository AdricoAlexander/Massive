package com.example.aqua_care.Screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.aqua_care.AlarmManager.scheduleNotification
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.SharedPreferencesManager
import com.example.aqua_care.Navigation.navScreen
import com.example.aqua_care.R
import java.util.*

@Composable
fun detailJadwal(
    modifier: Modifier = Modifier,
    navController: NavController,
    isFeedEnabled: Boolean
) {
    var checked by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.BottomStart,
            modifier = modifier
                .fillMaxWidth()
                .height(67.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .fillMaxWidth(0.7f)
                    .padding(14.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_backarrow),
                    contentDescription = null,
                    modifier = modifier
                        .size(29.dp)
                        .clickable {
                            navController.navigate(navScreen.jadwalPage.route)
                        }
                )
                opensanstext(
                    text = "Pemberian Pakan",
                    size = 18.sp,
                    fontFamily = opensansbold,
                    onItemclicked = {},
                    color = Color(0xFF272727)
                )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.topline),
            contentDescription = null,
        )
        Spacer(modifier.height(31.dp))
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(10.dp),
                modifier = modifier
                    .size(323.dp, 46.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    opensanstext(
                        text = "Aktifkan Pengingat",
                        size = 12.sp,
                        fontFamily = opensansbold,
                        onItemclicked = {},
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
            Spacer(modifier.height(31.dp))
            if (checked) {
                ifchecked(viewModel = ScheduleViewModel())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ifchecked(
    modifier: Modifier = Modifier,
    viewModel: ScheduleViewModel
) {
    var checked by remember { mutableStateOf(viewModel.isFeedEnabled) }
    var checked2 by remember { mutableStateOf(false) }

    var scheduleDate by remember { mutableStateOf("") }
    var scheduleTime by remember { mutableStateOf("") }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val timePickerState = rememberTimePickerState()
    val datePickerState = rememberDatePickerState()

    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val dataStore = SharedPreferencesManager(context)

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        opensanstext(
            text = "Tipe Notifikasi",
            size = 12.sp,
            fontFamily = opensansregular,
            onItemclicked = {},
            color = Color(0xFF272727)
        )
        Spacer(modifier.height(11.dp))
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp),
                modifier = modifier
                    .size(317.dp, 48.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier
                            .width(127.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lonceng_icon),
                            contentDescription = null,
                            modifier = modifier
                                .size(23.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            opensanstext(
                                text = "Notifikasi",
                                size = 14.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {},
                                color = Color(0xFF272727)
                            )
                            opensanstext(
                                text = if (checked) {
                                    "ON"
                                } else {
                                    "OFF"
                                },
                                size = 10.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {},
                                color = Color(0xFF3C3C3C)
                            )
                        }
                    }
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
                    )
                }
            }
            Spacer(modifier.height(1.dp))
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
                shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
                modifier = modifier
                    .size(317.dp, 48.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(5.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = modifier
                            .width(127.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lonceng_icon),
                            contentDescription = null,
                            modifier = modifier
                                .size(23.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            opensanstext(
                                text = "Alarm",
                                size = 14.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {},
                                color = Color(0xFF272727)
                            )
                            opensanstext(
                                text = if (checked2) {
                                    "ON"
                                } else {
                                    "OFF"
                                },
                                size = 10.sp,
                                fontFamily = opensansregular,
                                onItemclicked = {},
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
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        opensanstext(
            text = "Atur Alarm dan Tanggal",
            size = 12.sp,
            fontFamily = opensansregular,
            onItemclicked = {},
            color = Color(0xFF272727)
        )
        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F6F6)),
            shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
            modifier = modifier
                .size(317.dp, 48.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_timer),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        showTimePicker = true
                                    }
                            )
                            Text(
                                text = "Alarm",
                                fontSize = 12.sp,
                                color = Color(0xFF272727)
                            )
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icon_date),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .clickable {
                                        showDatePicker = true
                                    }
                            )
                            Text(
                                text = "Tanggal",
                                fontSize = 12.sp,
                                color = Color(0xFF272727)
                            )
                        }
                    }
                }
            }
        }
    }
    Spacer(modifier.height(10.dp))
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = {
            Log.d("Alarm", "Scheduling notification for time: ${scheduleTime} and date: ${scheduleDate}")
            scheduleNotification(
                context = context,
                timePickerState = timePickerState,
                datePickerState = datePickerState,
                title = "Pemberian Pakan"
            )
        },
            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, Color.Black),
            modifier = modifier
                .size(130.dp, 50.dp)) {
            Text(text = "Atur")
        }
    }
    if (showDatePicker) {
        Dialog(onDismissRequest = { showDatePicker = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                tonalElevation = 8.dp,
                modifier = modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        modifier = modifier
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        TextButton(onClick = { showDatePicker = false }) {
                            Text("Cancel")
                        }
                        TextButton(onClick = {
                            val selectedDate = Calendar.getInstance().apply { timeInMillis = datePickerState.selectedDateMillis!! }
                            scheduleDate = "${selectedDate.get(Calendar.DAY_OF_MONTH)}/${selectedDate.get(Calendar.MONTH) + 1}/${selectedDate.get(Calendar.YEAR)}"
                            showDatePicker = false
                        }) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }
    if (showTimePicker) {
        Dialog(onDismissRequest = { showTimePicker = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                tonalElevation = 8.dp,
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    TimePicker(
                        state = timePickerState
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row {
                        TextButton(onClick = { showTimePicker = false }) {
                            Text("Cancel")
                        }
                        TextButton(onClick = {
                            scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                            showTimePicker = false
                        }) {
                            Text("OK")
                        }
                    }
                }
            }
        }
    }
}