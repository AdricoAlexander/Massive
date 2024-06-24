package com.example.aqua_care.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aqua_care.chatBot.Model.ChatRequest
import com.example.aqua_care.chatBot.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

data class ChatMessage(
    val text: String,
    val isUser: Boolean
)

class ChatViewModel : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages

    private val _loading = MutableStateFlow(false)
    val loading : StateFlow<Boolean> = _loading

    fun sendMessage(text: String, isUser: Boolean = true) {
        val newMessage = ChatMessage(text, isUser)
        _messages.value = _messages.value + newMessage
        if (isUser) {
            viewModelScope.launch {
                _loading.value = true
                try {
                    val requestBody = ChatRequest(query = text)
                    val response = RetrofitInstance.api.sendMessage(requestBody).awaitResponse()
                    if (response.isSuccessful) {
                        val botResponse = response.body()?.response?.trim() ?: "Sorry, I didn't understand that."
                        _messages.value = _messages.value + ChatMessage(botResponse, isUser = false)
                    } else {
                        _messages.value = _messages.value + ChatMessage("Error: ${response.errorBody()?.string()}", isUser = false)
                    }
                } catch (e: Exception) {
                    _messages.value = _messages.value + ChatMessage("Error: ${e.message}", isUser = false)
                } finally {
                    _loading.value = false
                }
            }
        }
    }
}
