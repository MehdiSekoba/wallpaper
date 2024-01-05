package com.mehdisekoba.wallpaper.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mehdisekoba.wallpaper.data.network.ApiServices
import com.mehdisekoba.wallpaper.ui.collections.CollectionPagingSource
import javax.inject.Inject

class CollectionsRepository @Inject constructor(private val api: ApiServices) {

    fun getCollections(page: Int, perPage: Int) = Pager(
        config = PagingConfig(pageSize = perPage, prefetchDistance = 10, enablePlaceholders = false),
        pagingSourceFactory = { CollectionPagingSource(api, page, perPage) },
    ).liveData
}
