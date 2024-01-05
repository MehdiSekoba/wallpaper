package com.mehdisekoba.wallpaper.utils.service

interface DownloadCompleteListener {
    fun downloadFile(fileName: String, url: String): Long
}
