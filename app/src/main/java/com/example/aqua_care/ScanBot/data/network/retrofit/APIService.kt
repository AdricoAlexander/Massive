package com.example.aqua_care.ScanBot.data.network.retrofit

import com.example.aqua_care.ScanBot.data.network.response.ModelResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("predict")
    suspend fun uploadImage(
        @Part file: MultipartBody.Part
    ): ModelResponse
}