package com.mehdisekoba.wallpaper.data.repository

import com.mehdisekoba.wallpaper.data.network.ApiServices
import javax.inject.Inject

class DetailRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getDetailPhoto(id: String) = api.getDetailPhoto(id)
}
