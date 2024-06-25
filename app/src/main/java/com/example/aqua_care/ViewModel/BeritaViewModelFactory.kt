package com.example.aqua_care.ViewModel

import BeritaViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aqua_care.Berita.Retrofit.BeritaRepository

class BeritaViewModelFactory(
    private val repository: BeritaRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BeritaViewModel::class.java)) {
            return BeritaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
