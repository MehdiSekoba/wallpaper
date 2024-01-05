package com.mehdisekoba.wallpaper.utils.network

import com.google.gson.Gson
import com.mehdisekoba.wallpaper.data.model.ResponseErrors
import retrofit2.Response

open class NetworkResponse<T>(private val response: Response<T>) {

    open fun generateResponse(): NetworkRequest<T> {
        return when {
            response.code() == 400 -> NetworkRequest.Error("The request was unacceptable")
            response.code() == 401 -> NetworkRequest.Error("You are not authorized")
            response.code() == 403 -> NetworkRequest.Error("Missing permissions to perform request")
            response.code() == 404 -> NetworkRequest.Error("The requested resource does’t exist")
            response.code() == 422 -> {
                var errorMessage = ""
                if (response.errorBody() != null) {
                    val errorResponse = Gson().fromJson(response.errorBody()?.charStream(), ResponseErrors::class.java)

                    val errors = errorResponse.errors
                    errors?.forEach {
                        errorMessage = it
                    }
                }
                NetworkRequest.Error(errorMessage)
            }
            response.code() == 500 -> NetworkRequest.Error("Try again")
            response.isSuccessful -> NetworkRequest.Success(response.body()!!)
            else -> NetworkRequest.Error(response.message())
        }
    }
}
