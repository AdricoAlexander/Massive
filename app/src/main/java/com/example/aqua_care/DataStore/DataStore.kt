package com.example.aqua_care.DataStore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.aqua_care.DataStore.preferencesKey.FIRST_TIME_LAUNCH_KEY
import com.example.aqua_care.DataStore.preferencesKey.STATUS_LOGIN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("StatusLogin")
    }

    val getStatusLogin: Flow<Boolean> = context.dataStore.data.map {preferences ->
        preferences[STATUS_LOGIN_KEY] ?: false
    }
    val getFirstLaunch: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[FIRST_TIME_LAUNCH_KEY] ?: true
    }
    suspend fun saveStatus(isLogin : Boolean) = context.dataStore.edit { preferences ->
        preferences[STATUS_LOGIN_KEY] = isLogin
    }

    suspend fun clearStatus() = context.dataStore.edit { preferences ->
        preferences.remove(STATUS_LOGIN_KEY)
    }
    suspend fun setFirstTimeLaunch(isFirstTime : Boolean) = context.dataStore.edit { preferences ->
        preferences[FIRST_TIME_LAUNCH_KEY] = isFirstTime
    }
}
