package com.example.aqua_care.ScanBot.data.repository

import com.example.aqua_care.ScanBot.data.network.NetworkDataSource
import com.example.aqua_care.ScanBot.data.network.response.ModelResponse
import com.example.aqua_care.ScanBot.domain.DetectRepository
import com.example.aqua_care.ScanBot.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File
import javax.inject.Inject

class DetectRepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
): DetectRepository {
    override fun uploadImage(image: File): Flow<ResultState<ModelResponse>> = flow {
        emit(ResultState.Loading())
        try {
            val response = networkDataSource.uploadImage(image)
            emit(ResultState.Success(response))
        } catch (e: Exception){
            emit(ResultState.Error(e.message.toString()))
        }
    }

}