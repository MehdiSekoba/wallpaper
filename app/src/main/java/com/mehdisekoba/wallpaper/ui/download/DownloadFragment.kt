package com.mehdisekoba.wallpaper.ui.download

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.content.ContentUris
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mehdisekoba.wallpaper.data.model.local.InternalStoragePhoto
import com.mehdisekoba.wallpaper.databinding.FragmentDownloadBinding
import com.mehdisekoba.wallpaper.ui.MainActivity
import com.mehdisekoba.wallpaper.ui.download.adapter.PhotoAdapter
import com.mehdisekoba.wallpaper.utils.FOLDER_PATH
import com.mehdisekoba.wallpaper.utils.MESSAGE_PERMISSION
import com.mehdisekoba.wallpaper.utils.NEGATIVE_PERMISSION
import com.mehdisekoba.wallpaper.utils.POSITIVE_PERMISSION
import com.mehdisekoba.wallpaper.utils.TITLE_PERMISSION
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import com.mehdisekoba.wallpaper.utils.extensions.isVisible
import com.mehdisekoba.wallpaper.utils.extensions.sdk29AndUp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class DownloadFragment : BaseFragment<FragmentDownloadBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentDownloadBinding
        get() = FragmentDownloadBinding::inflate

    @Inject
    lateinit var photoAdapter: PhotoAdapter
    private val readImages = READ_MEDIA_IMAGES
    private val readExternal = READ_EXTERNAL_STORAGE
    private val permissions = arrayOf(
        readImages,
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPhotosFromExternalStorageIntoRecyclerView()
        requestPermissions()
    }

    private fun loadPhotosFromExternalStorageIntoRecyclerView() {
        lifecycleScope.launch {
            binding.apply {
                val photos = loadPhotosFromFolderPath()
                if (photos.isEmpty()) {
                    emptyLay.isVisible(true, downloadList)
                } else {
                    binding.emptyLay.isVisible(false, downloadList)

                    photoAdapter.setData(photos)
                    downloadList.apply {
                        adapter = photoAdapter
                        layoutManager =
                            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    }
                }
            }
        }
    }

    private suspend fun loadPhotosFromFolderPath(): List<InternalStoragePhoto> {
        return withContext(Dispatchers.IO) {
            val photos = mutableListOf<InternalStoragePhoto>()

            // Path to the specific folder
            val folderPath = FOLDER_PATH

            val projection = arrayOf(
                MediaStore.Images.Media._ID,
                MediaStore.Images.Media.DISPLAY_NAME,
                MediaStore.Images.Media.WIDTH,
                MediaStore.Images.Media.HEIGHT,
            )

            val selection = "${MediaStore.Images.Media.DATA} like ?"
            val selectionArgs = arrayOf("%$folderPath%")

            val collection = sdk29AndUp {
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }

            collection?.let {
                requireContext().contentResolver.query(
                    it,
                    projection,
                    selection,
                    selectionArgs,
                    "${MediaStore.Images.Media.DISPLAY_NAME} ASC",
                )?.use { cursor ->
                    val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
                    val displayNameColumn =
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
                    val widthColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.WIDTH)
                    val heightColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.HEIGHT)

                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(idColumn)
                        val displayName = cursor.getString(displayNameColumn)
                        val width = cursor.getInt(widthColumn)
                        val height = cursor.getInt(heightColumn)
                        val contentUri =
                            ContentUris.withAppendedId(
                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                                id,
                            )
                        photos.add(InternalStoragePhoto(id, displayName, width, height, contentUri))
                    }
                    photos.toList()
                }
            } ?: listOf()
        }
    }

    private fun requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val notGrantedPermissions = permissions.filterNot { permission ->
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    permission,
                ) == PackageManager.PERMISSION_GRANTED
            }
            if (notGrantedPermissions.isNotEmpty()) {
                val showRationale = notGrantedPermissions.any { permission ->
                    shouldShowRequestPermissionRationale(permission)
                }
                if (showRationale) {
                    AlertDialog.Builder(requireContext())
                        .setTitle(TITLE_PERMISSION)
                        .setMessage(MESSAGE_PERMISSION)
                        .setNegativeButton(NEGATIVE_PERMISSION) { dialog, _ ->
                            dialog.dismiss()
                        }
                        .setPositiveButton(POSITIVE_PERMISSION) { _, _ ->
                            ImagesPermission.launch(notGrantedPermissions.toTypedArray())
                        }
                        .show()
                } else {
                    ImagesPermission.launch(notGrantedPermissions.toTypedArray())
                }
            } else {
            }
        } else {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    readExternal,
                ) == PackageManager.PERMISSION_GRANTED
            ) {
            } else {
                if (shouldShowRequestPermissionRationale(readExternal)) {
                    AlertDialog.Builder(requireContext())
                        .setTitle(TITLE_PERMISSION)
                        .setMessage(MESSAGE_PERMISSION)
                        .setNegativeButton(NEGATIVE_PERMISSION) { dialog, _ ->
                            dialog.dismiss()
                        }
                        .setPositiveButton(POSITIVE_PERMISSION) { _, _ ->
                            readExternalPermission.launch(readExternal)
                        }
                        .show()
                } else {
                    readExternalPermission.launch(readExternal)
                }
            }
        }
    }

    private val ImagesPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissionMap ->
            if (permissionMap.all { it.value }) {
            } else {
            }
        }
    private val readExternalPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
            } else {
            }
        }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).setBottomNavigationVisibility(View.GONE)
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).setBottomNavigationVisibility(View.VISIBLE)
    }
}
