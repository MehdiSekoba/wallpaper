package com.mehdisekoba.wallpaper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehdisekoba.wallpaper.data.model.home.ResponseCategories
import com.mehdisekoba.wallpaper.data.model.search.ResponseSearch
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos
import com.mehdisekoba.wallpaper.data.repository.HomeRepository
import com.mehdisekoba.wallpaper.utils.SHORT_DELAY
import com.mehdisekoba.wallpaper.utils.network.NetworkRequest
import com.mehdisekoba.wallpaper.utils.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(SHORT_DELAY)
            callNewestPhotosApi()
        }
    }

    // Newest
    private val _newestPhotosData = MutableLiveData<NetworkRequest<ResponsePhotos>>()
    val newestPhotosData: LiveData<NetworkRequest<ResponsePhotos>> = _newestPhotosData

    private fun callNewestPhotosApi() = viewModelScope.launch {
        _newestPhotosData.value = NetworkRequest.Loading()
        val response = repository.getNewestPhotos()
        _newestPhotosData.value = NetworkResponse(response).generateResponse()
    }

    // Banner
    private val _bannerData = MutableLiveData<NetworkRequest<ResponseSearch>>()
    val bannerData: LiveData<NetworkRequest<ResponseSearch>> = _bannerData
    fun callBannerApi(queries: String) = viewModelScope.launch {
        _bannerData.value = NetworkRequest.Loading()
        val response = repository.getSearchBannerHome(queries)
        _bannerData.value = NetworkResponse(response).generateResponse()
    }

    // Categories
    private val _categoriesData = MutableLiveData<NetworkRequest<ResponseCategories>>()
    val categoriesData: LiveData<NetworkRequest<ResponseCategories>> = _categoriesData
    fun callCategoriesApi() = viewModelScope.launch {
        _categoriesData.value = NetworkRequest.Loading()
        val response = repository.getCategoriesList()
        _categoriesData.value = NetworkResponse(response).generateResponse()
    }
}
