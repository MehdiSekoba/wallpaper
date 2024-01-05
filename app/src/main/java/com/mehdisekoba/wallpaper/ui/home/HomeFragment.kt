package com.mehdisekoba.wallpaper.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.HeroCarouselStrategy
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.data.model.home.ResponseCategories.ResponseCategoriesItem
import com.mehdisekoba.wallpaper.data.model.search.ResponseSearch.Result
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos.ResponsePhotosItem
import com.mehdisekoba.wallpaper.databinding.FragmentHomeBinding
import com.mehdisekoba.wallpaper.ui.MainActivity
import com.mehdisekoba.wallpaper.ui.home.adapter.BannerAdapter
import com.mehdisekoba.wallpaper.ui.home.adapter.CategoriesAdapter
import com.mehdisekoba.wallpaper.ui.home.adapter.HomeAdapter
import com.mehdisekoba.wallpaper.utils.BANNER_COUNT
import com.mehdisekoba.wallpaper.utils.DELAY_TIME
import com.mehdisekoba.wallpaper.utils.GIRL_FACE
import com.mehdisekoba.wallpaper.utils.ITEM_COUNT
import com.mehdisekoba.wallpaper.utils.NATURE
import com.mehdisekoba.wallpaper.utils.NICE
import com.mehdisekoba.wallpaper.utils.RANDOM
import com.mehdisekoba.wallpaper.utils.REPEAT_TIME
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.setStatusBarIconsColor
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.utils.extensions.setupShimmerRecyclerview
import com.mehdisekoba.wallpaper.utils.extensions.showSnackBarBase
import com.mehdisekoba.wallpaper.utils.extensions.showSnackBarCheckConnection
import com.mehdisekoba.wallpaper.utils.network.NetworkRequest
import com.mehdisekoba.wallpaper.viewmodel.HomeViewModel
import com.mehdisekoba.wallpaper.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    @Inject
    lateinit var bannerAdapter: BannerAdapter

    @Inject
    lateinit var categoriesAdapter: CategoriesAdapter

    @Inject
    lateinit var homeAdapter: HomeAdapter

    // other
    private val viewModel by viewModels<HomeViewModel>()
    private val searchViewModel by viewModels<SearchViewModel>()
    private var autoScrollIndex = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set color for status bar icons
        requireActivity().setStatusBarIconsColor(true)
        // initViews
        binding.apply {
            // Support toolbar
            (activity as AppCompatActivity).setSupportActionBar(Toolbar)
            // click open drawer
            Toolbar.setNavigationOnClickListener { view ->
                (activity as MainActivity).openCloseNavigationDrawer(view)
            }
            // check network
            if (isNetworkAvailable) {
                // Banner
                val searchTerm = randomShowData()
                viewModel.callBannerApi(searchTerm)
                // Categorise
                viewModel.callCategoriesApi()
                // Random
                searchViewModel.updateSearchQuery(RANDOM)
                // Load Data
                loadData()
            } else {
                root.showSnackBarCheckConnection(R.string.default_message.toString())
            }
        }
    }

    private fun loadData() {
        loadBannersData()
        loadCategoriesData()
        loadRandomData()
        setUpSearch()
    }

    // Banner
    private fun loadBannersData() {
        binding.apply {
            viewModel.bannerData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        setupLoading(true, rcBanner)
                    }

                    is NetworkRequest.Success -> {
                        setupLoading(false, rcBanner)
                        response.data?.let { data ->
                            initBannerRecycler(data.results!!)
                            autoScrollBanner(data.results)
                        }
                    }

                    is NetworkRequest.Error -> {
                        setupLoading(false, rcBanner)
                    }
                }
            }
        }
    }

    private fun initBannerRecycler(list: List<Result>) {
        binding.rcBanner.isNestedScrollingEnabled = false
        if (list.isNotEmpty()) {
            ITEM_COUNT = if (list.size < BANNER_COUNT) {
                list.size
            } else {
                BANNER_COUNT
            }
            bannerAdapter.setData(list)
            binding.rcBanner.setupShimmerRecyclerview(
                CarouselLayoutManager(HeroCarouselStrategy()),
                bannerAdapter,

            )
            CarouselLayoutManager.HORIZONTAL
        }
        bannerAdapter.setOnItemClickListener {
            val direction = HomeFragmentDirections.actionToDetail(it)
            findNavController().navigate(direction)
        }
    }

    // autoScrollBanner
    private fun autoScrollBanner(list: List<Result>) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                repeat(REPEAT_TIME) {
                    delay(DELAY_TIME)
                    if (autoScrollIndex < list.size) {
                        autoScrollIndex += 1
                    } else {
                        autoScrollIndex = 0
                    }
                    binding.rcBanner.smoothScrollToPosition(autoScrollIndex)
                }
            }
        }
    }

    // random show data
    private fun randomShowData(): String {
        val list = listOf(GIRL_FACE, NATURE, NICE)
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }

    // Categories
    private fun loadCategoriesData() {
        binding.apply {
            viewModel.categoriesData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        setupLoading(true, categoryRecycler)
                    }

                    is NetworkRequest.Success -> {
                        setupLoading(false, categoryRecycler)
                        response.data?.let { data ->
                            if (data.isNotEmpty()) {
                                categoriesAdapter.setData(data)
                                initCategoriesRecycler(data)
                            }
                        }
                    }

                    is NetworkRequest.Error -> {
                        setupLoading(false, categoryRecycler)
                        root.showSnackBarBase(response.error!!)
                    }
                }
            }
        }
    }

    private fun initCategoriesRecycler(list: List<ResponseCategoriesItem>) {
        binding.categoryRecycler.isNestedScrollingEnabled = false
        categoriesAdapter.setData(list)
        binding.categoryRecycler.setupShimmerRecyclerview(
            LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false,
            ),
            categoriesAdapter,
        )

        // Click
        categoriesAdapter.setOnItemClickListener { id, title, photo ->
            val direction = HomeFragmentDirections.actionToCategories(id, title, photo)
            findNavController().navigate(direction)
        }
    }

    // Random
    private fun loadRandomData() {
        binding.apply {
            viewModel.newestPhotosData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        setupLoading(true, binding.shimmer)
                    }

                    is NetworkRequest.Success -> {
                        setupLoading(false, binding.shimmer)
                        response.data?.let { data ->
                            if (data.isNotEmpty()) {
                                initRandomRecyclerView(data)
                            }
                        }
                    }

                    is NetworkRequest.Error -> {
                        setupLoading(false, binding.shimmer)
                        root.showSnackBarBase(response.error!!)
                    }
                }
            }
        }
    }

    private fun initRandomRecyclerView(
        list: List<ResponsePhotosItem>,
    ) {
        binding.apply {
            homeAdapter.setData(list)
            RandomRecycler.apply {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                adapter = homeAdapter
                isNestedScrollingEnabled = false
            }
        }

        // Click
        homeAdapter.setOnItemClickListener {
            val direction = HomeFragmentDirections.actionToDetail(it)
            findNavController().navigate(direction)
        }
    }

    // search
    private fun setUpSearch() {
        (requireActivity() as MenuHost).addMenuProvider(
            object : MenuProvider {
                override fun onPrepareMenu(menu: Menu) {
                }
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.top_app_bar, menu)
                    val search = menu.findItem(R.id.actionSearch)
                    val searchView = search.actionView as SearchView
                    searchView.queryHint = getString(R.string.search)
                    searchView.setOnQueryTextListener(object :
                        SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String): Boolean {
                            if (query.isNotEmpty()) {
                                val direction = HomeFragmentDirections.actionToSearch(query)
                                findNavController().navigate(direction)
                            } else {
                                binding.root.showSnackBarBase(getString(R.string.searchCanNotBeEmpty))
                            }

                            return true
                        }

                        override fun onQueryTextChange(newText: String): Boolean {
                            return false
                        }
                    })
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return when (menuItem.itemId) {
                        R.id.actionSearch -> {
                            true
                        }

                        else -> false
                    }
                }
            },
            viewLifecycleOwner,
            Lifecycle.State.RESUMED,
        )
    }
}
