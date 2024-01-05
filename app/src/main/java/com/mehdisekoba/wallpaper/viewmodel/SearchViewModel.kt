package com.mehdisekoba.wallpaper.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mehdisekoba.wallpaper.data.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository, state: SavedStateHandle) : ViewModel() {

    private val currentData = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)

    val searchPhotos = currentData.switchMap { query ->
        repository.searchPhotos(query).cachedIn(viewModelScope)
    }

    fun updateSearchQuery(query: String) {
        currentData.value = query
    }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = ""
    }
}
