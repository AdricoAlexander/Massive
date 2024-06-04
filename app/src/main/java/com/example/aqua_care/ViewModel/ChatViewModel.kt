package com.example.aqua_care.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.aqua_care.chatBot.API
import com.example.aqua_care.chatBot.ChatRequest
import com.example.aqua_care.chatBot.ChatResponse
import com.example.aqua_care.chatBot.RetrofitInstance
import retrofit2.awaitResponse

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

class ChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    fun sendMessage(text: String, isUser: Boolean = true) {
        val newMessage = ChatMessage(text, isUser)
        _messages.value = _messages.value + newMessage
        if (isUser) {
            viewModelScope.launch {
                try {
                    val requestBody = ChatRequest(message = text)
                    val response = RetrofitInstance.api.sendMessage(requestBody).awaitResponse()
                    if (response.isSuccessful) {
                        val botResponse = response.body()?.response?.trim() ?: "Sorry, I didn't understand that."
                        _messages.value = _messages.value + ChatMessage(botResponse, isUser = false)
                    } else {
                        _messages.value = _messages.value + ChatMessage("Error: ${response.errorBody()?.string()}", isUser = false)
                    }
                } catch (e: Exception) {
                    _messages.value = _messages.value + ChatMessage("Error: ${e.message}", isUser = false)
                }
            }
        }
    }
}
