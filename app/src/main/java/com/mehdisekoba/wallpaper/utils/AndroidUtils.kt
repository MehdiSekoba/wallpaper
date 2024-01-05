package com.mehdisekoba.wallpaper.utils

import android.content.Context
import javax.inject.Singleton
import kotlin.math.ceil

@Singleton
class AndroidUtils {
    companion object {
        fun dp(context: Context, value: Float): Int {
            val density = context.resources.displayMetrics.density

            return if (value == 0f) {
                0
            } else {
                ceil(density * value).toInt()
            }
        }
    }
}
