package com.example.solarustask.core.networking

data class ServerError(
    val status: String,
    val serverMessage: String,
    val statusCode: Int
)
