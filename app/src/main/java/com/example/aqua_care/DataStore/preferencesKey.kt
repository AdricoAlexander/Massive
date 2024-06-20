package com.example.aqua_care.DataStore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore by preferencesDataStore(name = "alarms")
object preferencesKey {
    const val NAME_PREF = "login_preferences"
    const val NAME_KEY = "name"
    const val PASSWORD_KEY = "password"

    val STATUS_LOGIN_KEY = booleanPreferencesKey("status_login")
    val FIRST_TIME_LAUNCH_KEY = booleanPreferencesKey("first_open")
}