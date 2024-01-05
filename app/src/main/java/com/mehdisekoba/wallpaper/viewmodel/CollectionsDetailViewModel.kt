package com.mehdisekoba.wallpaper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mehdisekoba.wallpaper.data.model.collections.detail.ResponseDetailCollections
import com.mehdisekoba.wallpaper.data.repository.CollectionsDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionsDetailViewModel @Inject constructor(private val repository: CollectionsDetailRepository, state: SavedStateHandle) : ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val collections: LiveData<PagingData<ResponseDetailCollections.ResponseDetailCollectionsItem>> =
        currentQuery.switchMap { query ->
            repository.getCollectionsDetail(query).cachedIn(viewModelScope)
        }

    fun updateQuery(query: String) {
        currentQuery.value = query
    }
    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = ""
    }
}
