package com.example.aqua_care.AlarmManager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_ID
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_TITLE_KEY
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
fun scheduleNotification(
    context: Context,
    timePickerState: TimePickerState,
    datePickerState: DatePickerState,
    title: String,
    alarmId : Int
) {
    val notificationId = alarmId
    val intent = Intent(context.applicationContext, ReminderReceiver::class.java).apply {
        putExtra(RMNDR_NOTI_TITLE_KEY, title)
        putExtra("NOTIFICATION_ID",notificationId )
    }

    val requestCode = notificationId
    val pendingIntent = PendingIntent.getBroadcast(
        context.applicationContext,
        requestCode,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    val selectedDate = Calendar.getInstance().apply {
        timeInMillis = datePickerState.selectedDateMillis!!
    }

    val year = selectedDate.get(Calendar.YEAR)
    val month = selectedDate.get(Calendar.MONTH)
    val day = selectedDate.get(Calendar.DAY_OF_MONTH)

    val calendar = Calendar.getInstance()
    calendar.set(year, month, day, timePickerState.hour, timePickerState.minute)

    alarmManager.setExactAndAllowWhileIdle(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        pendingIntent
    )

    Toast.makeText(context, "Alarm successfully set", Toast.LENGTH_SHORT).show()
}

fun cancelNotification(context: Context, notificationId: Int) {
    val intent = Intent(context.applicationContext, ReminderReceiver::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context.applicationContext,
        notificationId,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    alarmManager.cancel(pendingIntent)

}
