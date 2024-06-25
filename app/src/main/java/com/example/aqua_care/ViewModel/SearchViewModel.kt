package com.example.aqua_care.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aqua_care.Data.aquamodulData.modulList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class SearchViewModel : ViewModel(){
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _modul = MutableStateFlow(modulList)
    val modul = searchQuery
        .combine(_modul){text, modul ->
            if (text.isBlank()){
                modul
            } else {
                modul.filter {
                    it.matchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _modul.value
        )
    fun onSearchTextChange(text : String){
        _searchQuery.value = text
    }
}