package com.mehdisekoba.wallpaper.ui.category

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.palette.graphics.Palette
import coil.load
import coil.request.CachePolicy
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.FragmentCategoryBinding
import com.mehdisekoba.wallpaper.ui.category.adapter.CategoryAdapter
import com.mehdisekoba.wallpaper.utils.*
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.utils.extensions.showSnackBarCheckConnection
import com.mehdisekoba.wallpaper.utils.views.CustomGridLayoutManager
import com.mehdisekoba.wallpaper.viewmodel.CategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentCategoryBinding
        get() = FragmentCategoryBinding::inflate

    @Inject
    lateinit var categoryAdapter: CategoryAdapter

    // other
    private val viewModel by viewModels<CategoriesViewModel>()
    private val args by navArgs<CategoryFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // initViews
        binding.apply {
            // back
            toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

            // Title photo
            args.let {
                if (isNetworkAvailable) {
                    // Call api
                    viewModel.updateCategoryId(it.id)
                    // Load data
                    loadData()
                    // Init functions
                    initRecyclerView()
                    loadDataStates()

                    viewLifecycleOwner.lifecycleScope.launch {
                        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                            delay(2000)
                            toolbar.isVisible = true
                            toolbar.title = "${it.title} ${getString(R.string.photos)}"
                            headerImg.load(it.photo) {
                                allowHardware(false)
                                diskCachePolicy(CachePolicy.ENABLED)
                                crossfade(true)
                                crossfade(500)
                                listener(
                                    onSuccess = { _, result ->
                                        createPalette(result.drawable.toBitmap())
                                    },
                                )
                            }
                        }
                    }
                } else {
                    binding.root.showSnackBarCheckConnection(R.string.checkConnection.toString())
                }
            }
            // shimmer
            setupLoading(true, shimmer)
        }
    }

    private fun loadData() {
        setupLoading(true, binding.shimmer)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                delay(2000)
                viewModel.categoriesPhotos.observe(viewLifecycleOwner) {
                    categoryAdapter.submitData(lifecycle, it)
                    setupLoading(false, binding.shimmer)
                }
            }
        }
    }

    private fun initRecyclerView() {
        if (categoryAdapter.itemCount > 0) {
            setupLoading(false, binding.shimmer)
            binding.shimmer.isVisible = false
        }

        binding.categoryRecycler.apply {
            layoutManager = CustomGridLayoutManager()
            adapter =
                categoryAdapter.withLoadStateFooter(LoadMoreAdapter { categoryAdapter.retry() })
        }
        // Click
        categoryAdapter.setOnItemClickListener {
            val direction = CategoryFragmentDirections.actionToDetail(it)
            findNavController().navigate(direction)
        }
    }

    private fun loadDataStates() {
        categoryAdapter.addLoadStateListener { state ->
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

    private fun createPalette(bitmap: Bitmap) {
        val palette = Palette.from(bitmap).generate()
        applyPaletteColors(palette.vibrantSwatch)
        applyPaletteColors(palette.darkVibrantSwatch)
        applyPaletteColors(palette.lightVibrantSwatch)
        applyPaletteColors(palette.lightMutedSwatch)
        applyPaletteColors(palette.mutedSwatch)
        applyPaletteColors(palette.darkMutedSwatch)
    }

    private fun applyPaletteColors(swatch: Palette.Swatch?) {
        swatch?.let {
            binding.collapsing.setContentScrimColor(it.rgb)
            binding.collapsing.setExpandedTitleColor(it.titleTextColor)
            binding.collapsing.setCollapsedTitleTextColor(it.titleTextColor)
            binding.toolbar.setNavigationIconTint(it.titleTextColor)
        }
    }
}
