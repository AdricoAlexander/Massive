package com.example.aqua_care.AlarmManager

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_CHNNL_ID
import com.example.aqua_care.AlarmManager.NotificationKeys.RMNDR_NOTI_ID
import com.example.aqua_care.R

class ReminderNotification(
    private val context : Context
){
    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun sendReminderNotification(
        title : String?
    ){
        val notification = NotificationCompat.Builder(context, RMNDR_NOTI_CHNNL_ID)
            .setContentTitle(title)
            .setContentText(context.getString(R.string.app_name))
            .setSmallIcon(R.drawable.icon_notification)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.icon_notification
                )
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(context.bitmapFromResource(R.drawable.icon_logo2))
            )
            .setAutoCancel(true)
            .build()
        notificationManager.notify(RMNDR_NOTI_ID, notification)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId : Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )
}