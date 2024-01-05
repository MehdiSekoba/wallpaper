package com.mehdisekoba.wallpaper.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mehdisekoba.wallpaper.data.network.ApiServices
import com.mehdisekoba.wallpaper.ui.collections.detail.CollectionDetailPagingSource
import javax.inject.Inject

class CollectionsDetailRepository @Inject constructor(private val api: ApiServices) {

    fun getCollectionsDetail(page: String) = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 10, enablePlaceholders = false),
        pagingSourceFactory = { CollectionDetailPagingSource(api, page) },
    ).liveData
}
