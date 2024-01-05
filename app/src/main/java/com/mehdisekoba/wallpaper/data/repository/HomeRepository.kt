package com.mehdisekoba.wallpaper.data.repository

import com.mehdisekoba.wallpaper.data.network.ApiServices
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: ApiServices) {
    suspend fun getNewestPhotos() = api.getNewestPhotos()
    suspend fun getSearchBannerHome(query: String) = api.getSearchBannerHome(query)
    suspend fun getCategoriesList() = api.getCategoriesList()
}
