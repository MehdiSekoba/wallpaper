package com.mehdisekoba.wallpaper.ui.collections

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehdisekoba.wallpaper.databinding.FragmentCollectionsBinding
import com.mehdisekoba.wallpaper.ui.collections.adapter.CollectionsAdapter
import com.mehdisekoba.wallpaper.utils.LoadMoreAdapter
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.viewmodel.CollectionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CollectionsFragment : BaseFragment<FragmentCollectionsBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentCollectionsBinding
        get() = FragmentCollectionsBinding::inflate

    @Inject
    lateinit var collectionsAdapter: CollectionsAdapter

    // other
    private val viewModel by viewModels<CollectionsViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isNetworkAvailable) {
            loadData()
            initRecyclerView()
            loadDataStates()
        }
    }

    private fun loadData() {
        setupLoading(true, binding.shimmer)
        viewModel.collections.observe(viewLifecycleOwner) {
            collectionsAdapter.submitData(lifecycle, it)
            setupLoading(false, binding.shimmer)
        }
    }

    private fun initRecyclerView() {
        if (collectionsAdapter.itemCount > 0) {
            setupLoading(false, binding.shimmer)
            binding.shimmer.isVisible = false
        }
        binding.photoList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter =
                collectionsAdapter.withLoadStateFooter(LoadMoreAdapter { collectionsAdapter.retry() })
        }

        // Click
        collectionsAdapter.setOnItemClickListener {
            val direction = CollectionsFragmentDirections.actionToCollectionDetail(it)
            findNavController().navigate(direction)
        }
    }

    private fun loadDataStates() {
        collectionsAdapter.addLoadStateListener { state ->
            binding.apply {
                loading.isVisible = state.source.refresh is LoadState.Loading
                photoList.isVisible = state.source.refresh is LoadState.NotLoading
                if (state.source.refresh is LoadState.NotLoading) {
                    setupLoading(false, shimmer)
                    binding.shimmer.isVisible = false
                }
            }
        }
    }
}
