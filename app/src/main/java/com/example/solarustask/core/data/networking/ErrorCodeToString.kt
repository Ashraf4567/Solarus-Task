package com.example.solarustask.core.data.networking

import com.example.solarustask.R

fun errorCodeToStringRes(errorCode: Int) : Int {
    return when(errorCode){
        400 -> R.string.bad_request
        401 -> R.string.unauthorized
        403 -> R.string.forbidden
        404 -> R.string.not_found
        else -> R.string.unknown_error
    }
}