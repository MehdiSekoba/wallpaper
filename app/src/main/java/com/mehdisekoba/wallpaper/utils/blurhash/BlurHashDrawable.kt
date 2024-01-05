package com.mehdisekoba.wallpaper.utils.blurhash

import android.content.Context
import android.graphics.* // ktlint-disable no-wildcard-imports
import android.graphics.drawable.Drawable
import androidx.annotation.StringRes
import androidx.core.graphics.withTranslation

class BlurHashDrawable(
    private val blurHash: String?,
    private val targetWidth: Int = SIZE_UNDEFINED, // Too large a resolution will affect performance
    private val targetHeight: Int = SIZE_UNDEFINED, // Too large a resolution will affect performance
) : Drawable() {

    companion object {
        internal const val SIZE_UNDEFINED = -1
    }

    constructor(
        context: Context,
        @StringRes hashRes: Int,
        targetWidth: Int = SIZE_UNDEFINED,
        targetHeight: Int = SIZE_UNDEFINED,
    ) : this(context.getString(hashRes), targetWidth, targetHeight)

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bitmap: Bitmap? = null

    override fun getIntrinsicHeight(): Int {
        return bitmap?.height ?: targetHeight
    }

    override fun getIntrinsicWidth(): Int {
        return bitmap?.width ?: targetWidth
    }

    override fun onBoundsChange(bounds: Rect) {
        updateBlurHash(bounds)
    }

    private fun calculateSize(boundSize: Int, targetSize: Int): Int {
        return if (targetSize > SIZE_UNDEFINED) targetSize else boundSize
    }

    private fun updateBlurHash(bounds: Rect) {
        val width = calculateSize(bounds.width(), targetWidth)
        val height = calculateSize(bounds.height(), targetHeight)
        val bitmap = this.bitmap
        if (bitmap != null) {
            if (width == bitmap.width && height == bitmap.height) {
                return
            }
        }
        this.bitmap = BlurHashDecoder.decode(blurHash, width, height)
        invalidateSelf()
    }

    override fun draw(canvas: Canvas) {
        val bitmap = this.bitmap ?: return
        val rect = bounds
        canvas.withTranslation(rect.left.toFloat(), rect.top.toFloat()) {
            drawBitmap(bitmap, 0f, 0f, paint)
        }
    }

    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
        invalidateSelf()
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
        invalidateSelf()
    }

    @Deprecated(
        "Deprecated in Java",
        ReplaceWith("PixelFormat.OPAQUE", "android.graphics.PixelFormat"),
    )
    override fun getOpacity(): Int {
        return PixelFormat.OPAQUE
    }
}
