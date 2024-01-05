package com.mehdisekoba.wallpaper.data.model

import com.google.gson.annotations.SerializedName

data class ResponseErrors(
    @SerializedName("errors")
    val errors: List<String>?
)