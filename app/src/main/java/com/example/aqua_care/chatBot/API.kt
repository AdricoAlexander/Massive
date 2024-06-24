package com.example.aqua_care.chatBot


import com.example.aqua_care.chatBot.Model.ChatRequest
import com.example.aqua_care.chatBot.Model.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface API {
    @POST("chat")
    fun sendMessage(@Body request: ChatRequest): Call<ChatResponse>
}