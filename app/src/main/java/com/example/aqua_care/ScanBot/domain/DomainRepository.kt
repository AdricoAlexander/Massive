package com.example.aqua_care.ScanBot.domain

import com.example.aqua_care.ScanBot.data.network.response.ModelResponse
import com.example.aqua_care.ScanBot.utils.ResultState
import kotlinx.coroutines.flow.Flow
import java.io.File


interface DetectRepository {
    fun uploadImage(image: File): Flow<ResultState<ModelResponse>>
}