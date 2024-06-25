package com.example.aqua_care.DataStore

import android.content.Context
import com.example.aqua_care.DataStore.preferencesKey.NAME_KEY
import com.example.aqua_care.DataStore.preferencesKey.NAME_PREF
import com.example.aqua_care.DataStore.preferencesKey.PASSWORD_KEY

class SharedPreferencesManager(context: Context) {
    private val preferences = context.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE)

    var name: String?
        get() = preferences.getString(NAME_KEY, "")
        set(value) {
            preferences.edit().apply {
                putString(NAME_KEY, value)
                apply()
            }
        }

    var password: String?
        get() = preferences.getString(PASSWORD_KEY, "")
        set(value) {
            preferences.edit().apply {
                putString(PASSWORD_KEY, value)
                apply()
            }
        }

    fun clear() {
        preferences.edit().apply {
            clear()
            apply()
        }
    }

}
