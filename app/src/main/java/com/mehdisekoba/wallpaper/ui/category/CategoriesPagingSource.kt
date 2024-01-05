package com.mehdisekoba.wallpaper.ui.category

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos
import com.mehdisekoba.wallpaper.data.network.ApiServices
import javax.inject.Inject

class CategoriesPagingSource @Inject constructor(private val api: ApiServices, private val id: String) :
    PagingSource<Int, ResponsePhotos.ResponsePhotosItem>() {

    private val pageIndex = 1

    override fun getRefreshKey(state: PagingState<Int, ResponsePhotos.ResponsePhotosItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponsePhotos.ResponsePhotosItem> {
        val position = params.key ?: pageIndex
        return try {
            val response = api.getCategoryPhotos(id, position)
            val data = response.body()!!

            LoadResult.Page(
                data = data,
                prevKey = if (position == pageIndex) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
