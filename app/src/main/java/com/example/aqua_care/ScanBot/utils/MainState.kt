package com.example.aqua_care.ScanBot.utils

import com.example.aqua_care.ScanBot.data.network.response.ModelResponse

data class MainState(
    val error: String? = null,
    val loading: Boolean = false,
    val success: Boolean = false,
    val result: ModelResponse? = null
)
