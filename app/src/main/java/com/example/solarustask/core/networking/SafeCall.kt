package com.example.solarustask.core.networking

import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Flow<Resource<T>> = flow {
    emit(Resource.Loading())
    try {
        val result = apiCall()
        emit(Resource.Success(result))
    } catch (e: Exception) {
        emit(handleException(e))
    }
}
    .flowOn(Dispatchers.IO)

private fun <T> handleException(exception: Exception): Resource<T> {
    return when (exception) {
                                                        // we could also use localized message here
        is TimeoutException -> Resource.Error(Exception("Request timed out"))
        is IOException -> Resource.Error(Exception("Network error, please try again"))
        is HttpException -> {
            val errorBody = exception.response()?.errorBody()?.string()
            val status = "Unknown"
            val serverMessage = errorBody ?: "Unknown error occurred"
            Resource.ServerError(
                ServerError(
                    status = status,
                    serverMessage = serverMessage,
                    statusCode = exception.code()
                )
            )
        }
        is JsonSyntaxException -> Resource.Error(Exception("Data parsing error"))
        else -> Resource.Error(Exception("Unexpected error occurred"))
    }
}