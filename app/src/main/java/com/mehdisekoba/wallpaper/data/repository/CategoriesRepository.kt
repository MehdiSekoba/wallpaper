package com.mehdisekoba.wallpaper.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.mehdisekoba.wallpaper.data.network.ApiServices
import com.mehdisekoba.wallpaper.ui.category.CategoriesPagingSource
import javax.inject.Inject

class CategoriesRepository @Inject constructor(private val api: ApiServices) {

    fun categoryPhotos(id: String) = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 10, enablePlaceholders = false),
        pagingSourceFactory = { CategoriesPagingSource(api, id) },
    ).liveData
}
