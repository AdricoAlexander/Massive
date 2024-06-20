package com.example.aqua_care.Screens

import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aqua_care.AlarmManager.AlarmList
import com.example.aqua_care.AlarmManager.AlarmType
import com.example.aqua_care.AlarmManager.TimePickerDialog
import com.example.aqua_care.AlarmManager.cancelNotification
import com.example.aqua_care.AlarmManager.scheduleNotification
import com.example.aqua_care.Data.aquaButton
import com.example.aqua_care.Data.opensansbold
import com.example.aqua_care.Data.opensansregular
import com.example.aqua_care.Data.opensanssemibold
import com.example.aqua_care.Data.opensanstext
import com.example.aqua_care.DataStore.AlarmRepository
import com.example.aqua_care.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun detailJadwal(
    modifier: Modifier = Modifier,
    navController: NavController,
    alarm: List<AlarmType>,
    alarmRepository: AlarmRepository
) {
    alarm.forEach { singleAlarm ->
        var checked by remember { mutableStateOf(singleAlarm.status) }
        val coroutineScope = rememberCoroutineScope()
        var scheduleDate by rememberSaveable { mutableStateOf(singleAlarm.date ?: "") }
        var scheduleTime by rememberSaveable { mutableStateOf(singleAlarm.time ?: "") }

        LaunchedEffect(singleAlarm.id) {
            alarmRepository.getAlarmStatus(singleAlarm.id).collect { status ->
                checked = status
            }
            alarmRepository.getAlarmDate(singleAlarm.id).collect { date ->
                scheduleDate = date
            }
            alarmRepository.getAlarmTime(singleAlarm.id).collect { time ->
                scheduleTime = time
            }
        }
        val context = LocalContext.current

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = modifier.fillMaxSize()
        ) {
            Box(
                contentAlignment = Alignment.BottomStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(67.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(14.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_backarrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(29.dp)
                            .clickable {
                                navController.navigateUp()
                            }
                    )
                    opensanstext(
                        text = singleAlarm.title,
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
            Spacer(modifier = Modifier.height(31.dp))

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Card(
                    colors = CardDefaults.cardColors(Color(0xFFF7F6F6)),
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
                            onItemclicked = {},
                            color = Color(0xFF272727)
                        )
                        Switch(
                            checked = checked,
                            onCheckedChange = { isChecked ->
                                checked = isChecked
                                coroutineScope.launch {
                                    alarmRepository.saveAlarmStatus(singleAlarm.id, isChecked)
                                }
                            },
                            colors = SwitchDefaults.colors(
                                checkedTrackColor = Color(0xFF246DBB),
                                checkedThumbColor = Color(0xFFFFFFFF),
                                uncheckedTrackColor = Color(0xFF969696),
                                uncheckedThumbColor = Color(0xFFFFFFFF)
                            ),
                            modifier = Modifier.size(40.dp, 20.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(31.dp))
                if (checked) {
                    AlarmScheduler(
                        title = singleAlarm.title,
                        initialScheduleDate = scheduleDate,
                        initialScheduleTime = scheduleTime,
                        alarmId = singleAlarm.id,
                        alarmRepository = alarmRepository
                    )
                }
            }
        }
    }
}




@Composable
fun AlarmConnector(
    modifier: Modifier = Modifier,
    alarmId: Int?,
    navController: NavController,
    alarmRepository: AlarmRepository
) {
    val alarm = AlarmList.alarmList.filter {
        it.id == alarmId
    }
    if (alarmId != null && alarm.isNotEmpty()){
        detailJadwal(modifier = modifier, navController = navController, alarm = alarm, alarmRepository = alarmRepository)
    } else {
        Text(text = "Alarm Tidak Ditemukan")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmScheduler(
    modifier: Modifier = Modifier,
    title : String,
    initialScheduleDate: String,
    initialScheduleTime: String,
    alarmId : Int,
    alarmRepository: AlarmRepository
){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }

    var scheduleDate by remember { mutableStateOf(initialScheduleDate) }
    var scheduleTime by remember { mutableStateOf(initialScheduleTime) }

    if (showDatePicker) {
        DatePickerDialog(onDismissRequest = {
            showDatePicker = false
        }, confirmButton = {
            TextButton(onClick = {
                val selectedDate = Calendar.getInstance().apply {
                    timeInMillis = datePickerState.selectedDateMillis!!
                }
                scheduleDate = formatter.format(selectedDate.time)
                coroutineScope.launch {
                    alarmRepository.saveAlarmDate(alarmId, scheduleDate)
                }
                showDatePicker = false
            }) {
                Text(text = "OK")
            }
        },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text(text = "Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                        coroutineScope.launch {
                            alarmRepository.saveAlarmTime(alarmId, scheduleTime)
                        }
                        showTimePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showTimePicker = false }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            TimePicker(state = timePickerState)
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .fillMaxSize()
    ){
        opensanstext(
            text = "Atur Alarm Notifikasi",
            size = 18.sp,
            fontFamily = opensansbold,
            onItemclicked = {  },
            color = Color(0xFF272727)
        )
        OutlinedTextField(
            value = scheduleDate,
            onValueChange = {
                scheduleDate = it
            },
            trailingIcon = {
                IconButton(onClick = {
                    showDatePicker = true
                }) {
                    Icon(painter = painterResource(id = R.drawable.icon_date),
                        contentDescription = null
                    )
                }
            },
            label = {
                Text(text = "Tanggal")
            },
            enabled = false,
            singleLine = true
        )
        OutlinedTextField(
            value = scheduleTime,
            onValueChange = {
                scheduleTime = it
            },
            trailingIcon = {
                IconButton(onClick = {
                    showTimePicker = true
                }) {
                    Icon(painter = painterResource(id = R.drawable.icon_timer),
                        contentDescription = null
                    )
                }
            },
            label = {
                Text(text = "Waktu")
            },
            enabled = false,
            singleLine = true
        )
        Row(
            modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            aquaButton(
                color = Color(0xFF246DBB),
                width = 150.dp,
                height = 50.dp,
                textColor = Color(0xFFFFFFFF),
                text = "Set Alarm",
                fontFamily = opensansregular
            ) {
                if (title.isBlank() || scheduleDate.isBlank() || scheduleTime.isBlank()) {
                    Toast.makeText(
                        context,
                        "Semua field wajib diisi!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    scheduleNotification(
                        context,
                        timePickerState,
                        datePickerState,
                        title,
                        alarmId
                    )
                    scheduleDate = ""
                    scheduleTime = ""
                }
            }
            aquaButton(
                color = Color(0xFFFFFFFF),
                width = 150.dp,
                height = 50.dp,
                textColor = Color(0xFF246DBB),
                text = "Cancel Alarm",
                fontFamily = opensansregular
            ) {
                cancelNotification(context, alarmId)
                Toast.makeText(context, "Alarm successfully cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}