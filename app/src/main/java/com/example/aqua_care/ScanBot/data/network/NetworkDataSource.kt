package com.example.aqua_care.ScanBot.data.network

import com.example.aqua_care.ScanBot.data.network.response.ModelResponse
import com.example.aqua_care.ScanBot.data.network.retrofit.ApiService
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun uploadImage(image: File): ModelResponse {
        val requestImageFile = image.asRequestBody("image/jpeg".toMediaTypeOrNull())
        val imageMultiPart = MultipartBody.Part.createFormData(
            "file",
            image.name,
            requestImageFile
        )
        return apiService.uploadImage(imageMultiPart)
    }
}