package com.mehdisekoba.wallpaper.utils.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.facebook.shimmer.ShimmerFrameLayout
import com.fondesa.kpermissions.PermissionStatus
import com.fondesa.kpermissions.request.PermissionRequest
import com.google.android.material.snackbar.Snackbar
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.CustomSnackbarBinding
import com.mehdisekoba.wallpaper.utils.blurhash.blurHash
import com.mikelau.shimmerrecyclerviewx.ShimmerRecyclerViewX
import java.text.DecimalFormat

fun ImageView.loadImageByBlurHash(url: String, blurHashString: String) {
    this.load(url) {
        blurHash(blurHashString)
        crossfade(true)
        crossfade(500)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}

fun ImageView.loadImage(url: String) {
    this.load(url) {
        crossfade(true)
        crossfade(500)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}

fun setupLoading(isShownLoading: Boolean, shimmer: ShimmerRecyclerViewX) {
    shimmer.apply {
        if (isShownLoading) showShimmerAdapter() else hideShimmerAdapter()
    }
}

fun ShimmerRecyclerViewX.setupShimmerRecyclerview(
    layoutManager: RecyclerView.LayoutManager,
    adapter: RecyclerView.Adapter<*>,
) {
    this.apply {
        setAdapter(adapter)
        setLayoutManager(layoutManager)
    }
}

fun Int.separating(): String {
    return DecimalFormat("#,###.##").format(this)
}

@SuppressLint("RestrictedApi")
fun View.showSnackBarCheckConnection(message: String) {
    val snackBar = Snackbar.make(this, "", Snackbar.LENGTH_LONG)
    val snackBarLayout = snackBar.view as Snackbar.SnackbarLayout
    val customSnackBarBinding = CustomSnackbarBinding.inflate(LayoutInflater.from(context))
    snackBarLayout.rootView.layoutParams =
        (this.layoutParams as FrameLayout.LayoutParams).apply {
            gravity = Gravity.CENTER_HORIZONTAL
        }
    snackBarLayout.addView(customSnackBarBinding.root, 0)
    snackBarLayout.setPadding(0, 0, 0, 0)
    snackBarLayout.setBackgroundColor(Color.TRANSPARENT)
    customSnackBarBinding.apply {
        desc.text = message
    }
    snackBar.show()
}

fun View.showSnackBarBase(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun FragmentActivity.setStatusBarIconsColor(isDark: Boolean) {
    this.window.apply {
        WindowCompat.getInsetsController(this, this.decorView).apply {
            isAppearanceLightStatusBars = isDark
        }
    }
}

fun ImageView.setTint(@ColorRes color: Int) {
    ImageViewCompat.setImageTintList(
        this,
        ColorStateList.valueOf(ContextCompat.getColor(context, color)),
    )
}

fun setupLoading(isShownLoading: Boolean, shimmer: ShimmerFrameLayout) {
    shimmer.apply {
        if (isShownLoading) startShimmer() else stopShimmer()
    }
}

fun View.isVisible(isShowLoading: Boolean, container: View) {
    if (isShowLoading) {
        this.visibility = View.VISIBLE
        container.visibility = View.GONE
    } else {
        this.visibility = View.GONE
        container.visibility = View.VISIBLE
    }
}

inline fun <T> sdk29AndUp(onSdk29: () -> T): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        onSdk29()
    } else {
        null
    }
}
internal fun Context.showRationaleDialog(
    permissions: List<PermissionStatus>,
    request: PermissionRequest,
) {
    val msg = getString(
        R.string.rationale_permissions,
        permissions.toMessage<PermissionStatus.Denied.ShouldShowRationale>(),
    )

    AlertDialog.Builder(this)
        .setTitle(R.string.permissions_required)
        .setMessage(msg)
        .setPositiveButton(R.string.request_again) { _, _ ->
            // Send the request again.
            request.send()
        }
        .setNegativeButton(android.R.string.cancel, null)
        .show()
}

internal fun Context.showPermanentlyDeniedDialog(permissions: List<PermissionStatus>) {
    val msg = getString(
        R.string.permanently_denied_permissions,
        permissions.toMessage<PermissionStatus.Denied.Permanently>(),
    )

    AlertDialog.Builder(this)
        .setTitle(R.string.permissions_required)
        .setMessage(msg)
        .setPositiveButton(R.string.action_settings) { _, _ ->
            // Open the app's settings.
            val intent = createAppSettingsIntent()
            startActivity(intent)
        }
        .setNegativeButton(android.R.string.cancel, null)
        .show()
}

private fun Context.createAppSettingsIntent() = Intent().apply {
    action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    data = Uri.fromParts("package", packageName, null)
}

private inline fun <reified T : PermissionStatus> List<PermissionStatus>.toMessage(): String =
    filterIsInstance<T>()
        .joinToString { it.permission }

