package com.example.aqua_care.DataStore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlarmRepository(private val context : Context) {

    suspend fun saveAlarmStatus(alarmId: Int, status: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey("alarm_status_$alarmId")] = status
        }
    }

    suspend fun saveAlarmDate(alarmId: Int, date: String) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey("alarm_date_$alarmId")] = date
        }
    }

    suspend fun saveAlarmTime(alarmId: Int, time: String) {
        context.dataStore.edit { preferences ->
            preferences[stringPreferencesKey("alarm_time_$alarmId")] = time
        }
    }

    fun getAlarmStatus(alarmId: Int): Flow<Boolean> {
        return context.dataStore.data
            .map { preferences ->
                preferences[booleanPreferencesKey("alarm_status_$alarmId")] ?: false
            }
    }

    fun getAlarmDate(alarmId: Int): Flow<String> {
        return context.dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey("alarm_date_$alarmId")] ?: ""
            }
    }

    fun getAlarmTime(alarmId: Int): Flow<String> {
        return context.dataStore.data
            .map { preferences ->
                preferences[stringPreferencesKey("alarm_time_$alarmId")] ?: ""
            }
    }

}