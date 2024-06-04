package com.example.aqua_care.Firebase

import com.google.firebase.auth.AuthResult
import java.lang.Error

data class LoginState(
    val success: String? = "",
    val error: String? = "",
    val loading: Boolean = false
)

data class LoginGoogleState(
    val success: AuthResult? = null,
    val error: String? = "",
    val loading: Boolean = true
)