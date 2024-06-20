package com.example.aqua_care.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aqua_care.ScanBot.domain.DetectRepository
import com.example.aqua_care.ScanBot.utils.MainState
import com.example.aqua_care.ScanBot.utils.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject


    @HiltViewModel
    class ClassificationViewModel @Inject constructor(
        private val detectRepository : DetectRepository
    ): ViewModel() {
        private val _state = MutableStateFlow(MainState())
        val state = _state.asStateFlow()

        fun uploadImage(image: File) = viewModelScope.launch {
            detectRepository.uploadImage(image).collect {result ->
                when(result) {
                    is ResultState.Error -> {
                        _state.update {
                            it.copy(
                                loading = false,
                                error = result.message
                            )
                        }
                    }
                    is ResultState.Loading -> {
                        _state.update {
                            it.copy(
                                loading = true
                            )
                        }
                    }
                    is ResultState.Success -> {
                        _state.update {
                            it.copy(
                                loading = false,
                                success = true,
                                result = result.data
                            )
                        }
                    }
                }
            }
        }
        fun resetState(){
            _state.update {
                MainState()
            }
        }
    }