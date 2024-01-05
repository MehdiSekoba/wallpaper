package com.mehdisekoba.wallpaper.data.model.local

import android.net.Uri

data class InternalStoragePhoto(
    val id: Long,
    val name: String,
    val width: Int,
    val height: Int,
    val contentUri: Uri,
)
