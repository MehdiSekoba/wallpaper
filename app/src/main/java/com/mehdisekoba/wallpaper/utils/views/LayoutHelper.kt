package com.mehdisekoba.wallpaper.utils.views

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.mehdisekoba.wallpaper.utils.AndroidUtils

class LayoutHelper {
    companion object {
        const val MATCH_PARENT = -1
        const val WRAP_CONTENT = -2

        private fun getSize(context: Context, size: Float): Int {
            return (if (size < 0) size else AndroidUtils.dp(context, size)).toInt()
        }

        fun createFrame(
            context: Context,
            width: Float,
            height: Float,
            gravity: Int,
        ): FrameLayout.LayoutParams {
            return FrameLayout.LayoutParams(
                getSize(context, width),
                getSize(context, height),
                gravity,
            )
        }

        fun createFrame(
            context: Context,
            width: Int,
            height: Float,
            gravity: Int,
            leftMargin: Float,
            topMargin: Float,
            rightMargin: Float,
            bottomMargin: Float,
        ): FrameLayout.LayoutParams {
            val layoutParams =
                FrameLayout.LayoutParams(
                    getSize(context, width.toFloat()),
                    getSize(context, height),
                    gravity,
                )
            layoutParams.setMargins(
                AndroidUtils.dp(context, leftMargin),
                AndroidUtils.dp(context, topMargin),
                AndroidUtils.dp(context, rightMargin),
                AndroidUtils.dp(context, bottomMargin),
            )
            return layoutParams
        }

        fun createLinear(
            context: Context,
            width: Int,
            height: Int,
            gravity: Int,
            leftMargin: Int,
            topMargin: Int,
            rightMargin: Int,
            bottomMargin: Int,
        ): LinearLayout.LayoutParams {
            val layoutParams = LinearLayout.LayoutParams(
                getSize(context, width.toFloat()),
                getSize(context, height.toFloat()),
            )
            layoutParams.setMargins(
                AndroidUtils.dp(context, leftMargin.toFloat()),
                AndroidUtils.dp(context, topMargin.toFloat()),
                AndroidUtils.dp(context, rightMargin.toFloat()),
                AndroidUtils.dp(context, bottomMargin.toFloat()),
            )
            layoutParams.gravity = gravity
            return layoutParams
        }

        fun createLinear(
            context: Context,
            width: Int,
            height: Int,
            weight: Float,
            gravity: Int,
            leftMargin: Int,
            topMargin: Int,
            rightMargin: Int,
            bottomMargin: Int,
        ): LinearLayout.LayoutParams {
            val layoutParams = LinearLayout.LayoutParams(
                getSize(context, width.toFloat()),
                getSize(context, height.toFloat()),
                weight,
            )
            layoutParams.setMargins(
                AndroidUtils.dp(context, leftMargin.toFloat()),
                AndroidUtils.dp(context, topMargin.toFloat()),
                AndroidUtils.dp(context, rightMargin.toFloat()),
                AndroidUtils.dp(context, bottomMargin.toFloat()),
            )
            layoutParams.gravity = gravity
            return layoutParams
        }

        fun createLinear(context: Context, width: Int, height: Int): LinearLayout.LayoutParams {
            return LinearLayout.LayoutParams(
                getSize(context, width.toFloat()),
                getSize(context, height.toFloat()),
            )
        }

        fun createLinear(
            context: Context,
            width: Int,
            height: Int,
            gravity: Int,
        ): LinearLayout.LayoutParams {
            val layoutParams = LinearLayout.LayoutParams(
                getSize(context, width.toFloat()),
                getSize(context, height.toFloat()),
            )
            layoutParams.gravity = gravity
            return layoutParams
        }

        fun createLinear(
            context: Context,
            width: Int,
            height: Int,
            weight: Float,
            gravity: Int,
        ): LinearLayout.LayoutParams {
            val layoutParams = LinearLayout.LayoutParams(
                getSize(context, width.toFloat()),
                getSize(context, height.toFloat()),
                weight,
            )
            layoutParams.gravity = gravity
            return layoutParams
        }
    }
}
