package com.example.aqua_care.Berita.Retrofit

import com.example.aqua_care.Berita.Model.BeritaResponse
import retrofit2.http.GET


interface BeritaApi {
    @GET("antara/terbaru")
    suspend fun getLatestNews(): BeritaResponse
}
