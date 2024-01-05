package com.mehdisekoba.wallpaper.ui.collections

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mehdisekoba.wallpaper.data.model.collections.ResponseCollections
import com.mehdisekoba.wallpaper.data.network.ApiServices
import javax.inject.Inject

class CollectionPagingSource @Inject constructor(
    private val api: ApiServices,
    private val page: Int,
    private var perPage: Int,
) :
    PagingSource<Int, ResponseCollections.ResponseCollectionsItem>() {

    override fun getRefreshKey(state: PagingState<Int, ResponseCollections.ResponseCollectionsItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseCollections.ResponseCollectionsItem> {
        val nextPageNumber = params.key ?: page
        return try {
            val response = api.getCollections(nextPageNumber, perPage)
            val data = response.body()!!

            LoadResult.Page(
                data = data,
                prevKey = if (nextPageNumber == page) null else nextPageNumber - 1,
                nextKey = if (data.isEmpty()) null else nextPageNumber + 1,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
