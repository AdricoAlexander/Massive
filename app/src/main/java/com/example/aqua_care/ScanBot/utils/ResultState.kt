package com.example.aqua_care.ScanBot.utils

sealed class ResultState<out R> {
    data class Loading<out T>(val data: T? = null) : ResultState<T>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val message : String? = null) : ResultState<Nothing>()
}