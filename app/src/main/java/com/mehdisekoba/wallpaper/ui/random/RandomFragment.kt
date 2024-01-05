package com.mehdisekoba.wallpaper.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.FragmentRandomBinding
import com.mehdisekoba.wallpaper.ui.category.CategoryFragmentDirections
import com.mehdisekoba.wallpaper.ui.search.adapter.SearchAdapter
import com.mehdisekoba.wallpaper.utils.LoadMoreAdapter
import com.mehdisekoba.wallpaper.utils.POPULAR
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.utils.extensions.showSnackBarCheckConnection
import com.mehdisekoba.wallpaper.utils.views.CustomGridLayoutManager
import com.mehdisekoba.wallpaper.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RandomFragment : BaseFragment<FragmentRandomBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentRandomBinding
        get() = FragmentRandomBinding::inflate

    @Inject
    lateinit var searchAdapter: SearchAdapter

    // other
    private val viewModel by viewModels<SearchViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            if (isNetworkAvailable) {
                // Call api
                viewModel.updateSearchQuery(POPULAR)
                // Load data
                loadData()
                // Init functions
                initRecyclerView()
                loadDataStates()
            } else {
                binding.root.showSnackBarCheckConnection(R.string.checkConnection.toString())
            }
        }
    }
    private fun loadData() {
        setupLoading(true, binding.shimmer)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                delay(2000)
                viewModel.searchPhotos.observe(viewLifecycleOwner) {
                    searchAdapter.submitData(lifecycle, it)
                    setupLoading(false, binding.shimmer)
                }
            }
        }
    }

    private fun initRecyclerView() {
        if (searchAdapter.itemCount > 0) {
            setupLoading(false, binding.shimmer)
            binding.shimmer.isVisible = false
        }

        binding.categoryRecycler.apply {
            layoutManager = CustomGridLayoutManager()
            adapter =
                searchAdapter.withLoadStateFooter(LoadMoreAdapter { searchAdapter.retry() })
        }
        // Click
        searchAdapter.setOnItemClickListener {
            val direction = CategoryFragmentDirections.actionToDetail(it)
            findNavController().navigate(direction)
        }
    }

    private fun loadDataStates() {
        searchAdapter.addLoadStateListener { state ->
            binding.apply {
                loading.isVisible = state.source.refresh is LoadState.Loading
                categoryRecycler.isVisible = state.source.refresh is LoadState.NotLoading
                if (state.source.refresh is LoadState.NotLoading) {
                    setupLoading(false, shimmer)
                    binding.shimmer.isVisible = false
                }
            }
        }
    }
}
