package com.example.aqua_care.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aqua_care.Firebase.AuthRepository
import com.example.aqua_care.Firebase.LoginState
import com.example.aqua_care.Firebase.Resource
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirebaseViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val _state = Channel<LoginState>()
    val state = _state.receiveAsFlow()

    fun loginUser(email: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            repository.loginUser(email, password).collect {
                when (it) {
                    is Resource.Error -> {
                        _state.send(LoginState(error = it.message))
                        callback(false)
                    }
                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Login Berhasil"))
                        callback(true)
                    }
                }
            }
        }
    }

    fun registerUser(email: String, password: String, home: () -> Unit) {
        viewModelScope.launch {
            repository.registerUser(email, password).collect {
                when (it) {
                    is Resource.Error -> {
                        _state.send(LoginState(error = it.message))
                    }
                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Daftar Berhasil"))
                        home()
                    }
                }
            }
        }
    }

    fun resetPassword(email: String, callback: (Boolean) -> Unit){
        viewModelScope.launch {
            repository.resetPassword(email).collect {
                when (it){
                    is Resource.Error -> {
                        _state.send(LoginState(error = it.message))
                        callback(false)
                    }
                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Password reset email sent"))
                        callback(true)
                    }
                }
            }
        }
    }
}
