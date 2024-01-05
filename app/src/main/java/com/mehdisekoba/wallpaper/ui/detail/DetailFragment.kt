package com.mehdisekoba.wallpaper.ui.detail

import android.Manifest
import android.annotation.SuppressLint
import android.app.DownloadManager
import android.app.WallpaperManager
import android.content.IntentFilter
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.fondesa.kpermissions.coroutines.flow
import com.fondesa.kpermissions.extension.permissionsBuilder
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.FragmentDetailBinding
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.loadImage
import com.mehdisekoba.wallpaper.utils.extensions.setStatusBarIconsColor
import com.mehdisekoba.wallpaper.utils.extensions.setTint
import com.mehdisekoba.wallpaper.utils.extensions.setupLoading
import com.mehdisekoba.wallpaper.utils.extensions.showSnackBarCheckConnection
import com.mehdisekoba.wallpaper.utils.network.NetworkRequest
import com.mehdisekoba.wallpaper.utils.service.AndroidDownloader
import com.mehdisekoba.wallpaper.utils.service.DownloadCompletedReceiver
import com.mehdisekoba.wallpaper.utils.service.OnCompleteListener
import com.mehdisekoba.wallpaper.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(), OnCompleteListener {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentDetailBinding
        get() = FragmentDetailBinding::inflate

    @Inject
    lateinit var wallpaperManager: WallpaperManager

    // other
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()
    private lateinit var imageBitmap: Bitmap
    private val downloadReceiver = DownloadCompletedReceiver()
    private var imageId = "0"
    private lateinit var gestureDetector: GestureDetector
    private var maxScrollX = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        downloadReceiver.setDownloadCompleteListener(this)
        // Register the receiver
        val filter = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        requireContext().registerReceiver(downloadReceiver, filter)

        // Set color for status bar icons
        requireActivity().setStatusBarIconsColor(false)
        if (isNetworkAvailable) {
            // Args
            args.let {
                // Call api
                imageId = it.id
                viewModel.callDetailApi(imageId)
            }
            // Load data
            loadData()
        } else {
            binding.root.showSnackBarCheckConnection(R.string.checkConnection.toString())
        }

        gestureDetector = GestureDetector(requireContext(), MyGestureListener())
        binding.apply {
            scrollView.isHorizontalScrollBarEnabled = false
            // back
            imgBack.setOnClickListener { findNavController().popBackStack() }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun loadData() {
        binding.apply {
            viewModel.detailData.observe(viewLifecycleOwner) { response ->
                when (response) {
                    is NetworkRequest.Loading -> {
                        setupLoading(true, shimmer)
                        blurView.isVisible = false
                        imgBack.isVisible = false
                    }

                    is NetworkRequest.Success -> {
                        blurView.isVisible = true
                        imgBack.isVisible = true

                        setupLoading(false, shimmer)
                        response.data?.let { data ->
                            createBitmapFromImageView(data.urls?.regular!!)
                            imgWall.loadImage(data.urls.regular)
                            imgWall.setOnTouchListener { _, event ->
                                gestureDetector.onTouchEvent(event)
                                true
                            }
                            imgWall.post {
                                maxScrollX = imgWall.width - scrollView.width
                            }
                            // Set wallpaper
                            btnWallpaper.setOnClickListener {
                                showSetWallpaperDialog()
                            }
                            // Download
                            imgDownload.setOnClickListener {
                                requestPermission()
                                data.urls.full?.let {
                                    val downloader = AndroidDownloader(requireContext(), this)

                                    downloader.downloadFile(data.slug!!, it)
                                }
                            }
                            // information
                            imgInformation.setOnClickListener {
                                val direction = DetailFragmentDirections.actionDetailInfo(data)
                                findNavController().navigate(direction)
                            }
                        }
                    }

                    is NetworkRequest.Error -> {
                        blurView.isVisible = false
                        imgBack.isVisible = false

                        setupLoading(false, shimmer)
                    }
                }
            }
        }
    }

    private fun createBitmapFromImageView(imageUrl: String) {
        lifecycleScope.launch {
            // Create bitmap from image
            val loader = ImageLoader(requireContext())
            val request = ImageRequest.Builder(requireContext())
                .data(imageUrl)
                .allowHardware(false)
                .build()
            val result = (loader.execute(request) as SuccessResult).drawable
            imageBitmap = (result as BitmapDrawable).bitmap
        }
    }

    private fun showSetWallpaperDialog() {
        val dialog = OptionalDialog.Builder(requireContext())
            .setFirstOption(
                getString(R.string.set_home_screen),
                object : OptionalDialog.OptionalDialogClickListener {
                    override fun onClick(dialog: OptionalDialog) {
                        dialog.dismiss()
                        wallpaperManager.setBitmap(
                            imageBitmap,
                            null,
                            true,
                            WallpaperManager.FLAG_SYSTEM,
                        )
                    }
                },
            ).setSecondOption(
                getString(R.string.set_lock_screen),
                object : OptionalDialog.OptionalDialogClickListener {
                    override fun onClick(dialog: OptionalDialog) {
                        dialog.dismiss()
                        wallpaperManager.setBitmap(
                            imageBitmap,
                            null,
                            true,
                            WallpaperManager.FLAG_LOCK,
                        )
                    }
                },
            ).setThirdOption(
                getString(R.string.set_both),
                object : OptionalDialog.OptionalDialogClickListener {
                    override fun onClick(dialog: OptionalDialog) {
                        dialog.dismiss()
                        wallpaperManager.setBitmap(
                            imageBitmap,
                            null,
                            false,
                            WallpaperManager.FLAG_SYSTEM,
                        )
                    }
                },
            )
        dialog.show()
    }

    private fun requestPermission() {
        val context = requireContext()
        viewLifecycleOwner.lifecycleScope.launch {
            val request = permissionsBuilder(Manifest.permission.WRITE_EXTERNAL_STORAGE).build()
            launch {
                request.flow().collect { result ->
                    when {
                    }
                }
            }
            request.send()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Unregister the receiver when the fragment is destroyed
        requireContext().unregisterReceiver(downloadReceiver)
    }

    override fun onDownloadComplete() {
        val downloadImg = binding.imgDownload
        binding.downloadLoading.apply {
            visibility =
                if (visibility == View.VISIBLE) {
                    View.INVISIBLE
                } else {
                    View.VISIBLE
                }
        }
        downloadImg.apply {
            setImageResource(R.drawable.download)
            setTint(R.color.green)
        }
    }

    private inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent,
            distanceX: Float,
            distanceY: Float,
        ): Boolean {
            val newScrollX = binding.scrollView.scrollX + distanceX.toInt()
            val clampedScrollX = newScrollX.coerceIn(0, maxScrollX)
            binding.scrollView.scrollTo(clampedScrollX, 0)
            return true
        }

    }
}
