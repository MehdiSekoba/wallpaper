package com.mehdisekoba.wallpaper.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.data.model.splash.ResponsePhotos.ResponsePhotosItem
import com.mehdisekoba.wallpaper.databinding.CustomDialogBinding
import com.mehdisekoba.wallpaper.databinding.FragmentSplashBinding
import com.mehdisekoba.wallpaper.ui.splash.adapter.SplashAdapter
import com.mehdisekoba.wallpaper.utils.SPLASH_DELAY
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.* // ktlint-disable no-wildcard-imports
import com.mehdisekoba.wallpaper.utils.network.NetworkRequest
import com.mehdisekoba.wallpaper.utils.views.CustomGridLayoutManager
import com.mehdisekoba.wallpaper.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentSplashBinding
        get() = FragmentSplashBinding::inflate

    @Inject
    lateinit var adapterPhoto: SplashAdapter

    // other
    private val viewModel by viewModels<HomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set color for status bar icons
        requireActivity().setStatusBarIconsColor(false)

        if (isNetworkAvailable) {
            loadData()
        } else {
            showAlertDialog()
        }
    }

    private fun loadData() {
        binding.apply {
            viewModel.newestPhotosData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        setupLoading(true, photoList)
                        Shadow.isVisible = false
                    }

                    is NetworkRequest.Success -> {
                        Shadow.isVisible = true
                        setupLoading(false, photoList)

                        response.data?.let { data ->
                            if (data.isNotEmpty()) {
                                initNewestRecycler(data)
                                lifecycleScope.launch {
                                    delay(SPLASH_DELAY)
                                    findNavController().popBackStack(R.id.splashFragment, true)
                                    findNavController().navigate(R.id.actionToHome)
                                }
                            }
                        }
                    }

                    is NetworkRequest.Error -> {
                        setupLoading(false, photoList)
                        Shadow.isVisible = false
                        root.showSnackBarBase(response.error!!)
                    }
                }
            }
        }
    }

    private fun initNewestRecycler(list: List<ResponsePhotosItem>) {
        binding.apply {
            adapterPhoto.setData(list)
            photoList.setupShimmerRecyclerview(layoutManager = CustomGridLayoutManager(), adapterPhoto)
        }
    }

    // Disconnect Internet
    private fun showAlertDialog() {
        val layoutInflater = LayoutInflater.from(requireContext())
        val customDialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val bindingDialog = CustomDialogBinding.bind(customDialogView)

        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(bindingDialog.root)
            .setCancelable(false)

        val dialog = builder.create()
        dialog.show()

        bindingDialog.btnInternet.setOnClickListener {
            if (isNetworkAvailable) {
                with(findNavController()) {
                    popBackStack()
                    navigate(R.id.splashFragment)
                }
                dialog.dismiss()
            }
        }
    }
}
