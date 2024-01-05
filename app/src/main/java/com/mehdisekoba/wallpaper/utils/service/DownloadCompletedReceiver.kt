package com.mehdisekoba.wallpaper.utils.service

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.mehdisekoba.wallpaper.utils.DOWNLOAD_ID_Broadcast

class DownloadCompletedReceiver : BroadcastReceiver() {
    private var downloadCompleteListener: OnCompleteListener? = null
    fun setDownloadCompleteListener(listener: OnCompleteListener) {
        this.downloadCompleteListener = listener
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.intent.action.DOWNLOAD_COMPLETE") {
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
            if (id == DOWNLOAD_ID_Broadcast) {
                downloadCompleteListener?.onDownloadComplete()
            }
        }
    }
}
