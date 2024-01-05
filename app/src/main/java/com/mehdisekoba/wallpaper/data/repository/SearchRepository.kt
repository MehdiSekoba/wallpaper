package com.mehdisekoba.wallpaper.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mehdisekoba.wallpaper.data.network.ApiServices
import com.mehdisekoba.wallpaper.ui.search.SearchPagingSource
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api: ApiServices) {

    fun searchPhotos(query: String) = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 10, enablePlaceholders = false),
        pagingSourceFactory = { SearchPagingSource(api, query) },
    ).liveData
}
