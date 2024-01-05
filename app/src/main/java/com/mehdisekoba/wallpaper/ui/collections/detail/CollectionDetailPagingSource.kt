package com.mehdisekoba.wallpaper.ui.collections.detail

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mehdisekoba.wallpaper.data.model.collections.detail.ResponseDetailCollections.ResponseDetailCollectionsItem
import com.mehdisekoba.wallpaper.data.network.ApiServices
import javax.inject.Inject

class CollectionDetailPagingSource @Inject constructor(private val api: ApiServices, private val query: String) :
    PagingSource<Int, ResponseDetailCollectionsItem>() {

    private val pageIndex = 1

    override fun getRefreshKey(state: PagingState<Int, ResponseDetailCollectionsItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseDetailCollectionsItem> {
        val position = params.key ?: pageIndex
        return try {
            val response = api.getDetailCollections(query, position)
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




