package com.example.aqua_care

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aqua_care.DataStore.UserPreferences
import com.example.aqua_care.ViewModel.DataStoreViewModel

class MainViewModelFactory(private val userPreferences: UserPreferences) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataStoreViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DataStoreViewModel(userPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
