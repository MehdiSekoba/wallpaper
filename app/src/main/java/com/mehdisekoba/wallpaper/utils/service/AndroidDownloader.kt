package com.mehdisekoba.wallpaper.utils.service

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import com.mehdisekoba.wallpaper.databinding.FragmentDetailBinding
import com.mehdisekoba.wallpaper.utils.DOWNLOAD_ID_Broadcast
import com.mehdisekoba.wallpaper.utils.IMAGE_MIME_TYPE
import com.mehdisekoba.wallpaper.utils.JPG
import com.mehdisekoba.wallpaper.utils.WALLPAPER_4K
import java.io.File

class AndroidDownloader(
    private val context: Context,
    private val binding: FragmentDetailBinding,
) : DownloadCompleteListener {

    private val downloadManager =
        context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    override fun downloadFile(fileName: String, url: String): Long {
        binding.downloadLoading.apply {
            setPadding(16)
            isVisible = true
            isIndeterminate = true
        }

        val folder = File(
            context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)?.absolutePath +
                File.separator + WALLPAPER_4K,
        )

        if (!folder.exists()) {
            folder.mkdirs()
        }
        val request = DownloadManager.Request(url.toUri())
            .setMimeType(IMAGE_MIME_TYPE)
            .setAllowedNetworkTypes(
                DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE,
            )
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle(fileName)
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_PICTURES,
                "$WALLPAPER_4K${File.separator}$fileName$JPG",
            )
        DOWNLOAD_ID_Broadcast = downloadManager.enqueue(request)
        return DOWNLOAD_ID_Broadcast
    }
}
