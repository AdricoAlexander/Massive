package com.example.aqua_care.AlarmManager

data class AlarmType(
    val id : Int,
    val title : String,
    val status : Boolean,
    val time : String?,
    val date : String?
)

