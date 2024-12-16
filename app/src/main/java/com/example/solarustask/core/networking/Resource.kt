package com.example.solarustask.core.networking

sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val exception: Exception) : Resource<T>()
    data class ServerError<T>(val serverError: com.example.solarustask.core.networking.ServerError) : Resource<T>()
}