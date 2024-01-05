package com.mehdisekoba.wallpaper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mehdisekoba.wallpaper.data.model.collections.ResponseCollections
import com.mehdisekoba.wallpaper.data.repository.CollectionsRepository
import com.mehdisekoba.wallpaper.utils.CURRENT_PAGE
import com.mehdisekoba.wallpaper.utils.ITEMS_PER_PAGE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val repository: CollectionsRepository,
    state: SavedStateHandle,
) :
    ViewModel() {

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val collections: LiveData<PagingData<ResponseCollections.ResponseCollectionsItem>> =
        currentQuery.switchMap { query ->
            repository.getCollections(CURRENT_PAGE, ITEMS_PER_PAGE).cachedIn(viewModelScope)
        }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = ""
    }
}
