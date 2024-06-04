package com.example.aqua_care.AlarmManager

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_CHNNL_ID
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_CHNNL_NAME

class ScheduledNotificationApplication: Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = RMNDR_NOTI_CHNNL_NAME
            val descriptionText = "Channel for reminder notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(RMNDR_NOTI_CHNNL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
