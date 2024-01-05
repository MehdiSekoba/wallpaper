package com.mehdisekoba.wallpaper.ui.collections.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import com.mehdisekoba.wallpaper.databinding.FragmentCollectionsDetailBinding
import com.mehdisekoba.wallpaper.ui.category.CategoryFragmentDirections
import com.mehdisekoba.wallpaper.ui.collections.CollectionsFragmentDirections
import com.mehdisekoba.wallpaper.utils.LoadMoreAdapter
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.utils.views.CustomGridLayoutManager
import com.mehdisekoba.wallpaper.viewmodel.CollectionsDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CollectionsDetailFragment : BaseFragment<FragmentCollectionsDetailBinding>() {

    override val bindingInflater: (inflater: LayoutInflater) -> FragmentCollectionsDetailBinding
        get() = FragmentCollectionsDetailBinding::inflate

    @Inject
    lateinit var detailAdapter: CollectionsDetailAdapter

    // other
    private val viewModel by viewModels<CollectionsDetailViewModel>()
    private val args by navArgs<CollectionsDetailFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isNetworkAvailable) {
            args.let {
                viewModel.updateQuery(it.id)
                loadData()
                initRecyclerView()
                loadDataStates()
            }
        }
    }

    private fun loadData() {
        setupLoading(true, binding.shimmer)
        viewModel.collections.observe(viewLifecycleOwner) {
            detailAdapter.submitData(lifecycle, it)
            setupLoading(false, binding.shimmer)
        }
    }

    private fun initRecyclerView() {
        if (detailAdapter.itemCount > 0) {
            setupLoading(false, binding.shimmer)
            binding.shimmer.isVisible = false
        }
        binding.photoList.apply {
            layoutManager = CustomGridLayoutManager()
            adapter =
                detailAdapter.withLoadStateFooter(LoadMoreAdapter { detailAdapter.retry() })
        }

        // Click
        detailAdapter.setOnItemClickListener {
            val direction = CollectionsFragmentDirections.actionToDetail(it)
            findNavController().navigate(direction)
        }
    }

    private fun loadDataStates() {
        detailAdapter.addLoadStateListener { state ->
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
