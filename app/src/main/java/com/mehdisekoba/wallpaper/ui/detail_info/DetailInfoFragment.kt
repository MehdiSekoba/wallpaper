package com.mehdisekoba.wallpaper.ui.detail_info // ktlint-disable package-name

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.FragmentDetailInfoBinding
import com.mehdisekoba.wallpaper.utils.base.BaseBottomSheetDialogFragment
import com.mehdisekoba.wallpaper.utils.extensions.loadImage
import com.mehdisekoba.wallpaper.utils.extensions.separating
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailInfoFragment : BaseBottomSheetDialogFragment<FragmentDetailInfoBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentDetailInfoBinding
        get() = FragmentDetailInfoBinding::inflate

    // Other
    private val args by navArgs<DetailInfoFragmentArgs>()

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isNetworkAvailable) {
            args.data.let { data ->
                // InitViews
                binding.apply {
                    // User
                    data.user?.let { user ->
                        // Bio

                        if (user.bio.isNullOrEmpty().not()) {
                            TxtBio.text = "${"bio :"} ${user.bio}"
                        } else {
                            TxtBio.isVisible = false
                        }
                        userNameTxt.text = user.username
                        userPhotosCountTxt.text =
                            "${user.totalPhotos?.separating()} ${getString(R.string.photos)}"
                        user.profileImage?.large?.let { avatar ->
                            userAvatarImg.loadImage(avatar)
                        }
                        data.location?.let { locationUser ->
                            val locationStringBuilder = StringBuilder()

                            if (!locationUser.country.isNullOrEmpty()) {
                                locationStringBuilder.append(locationUser.country)
                            }

                            if (!locationUser.city.isNullOrEmpty() && !locationUser.city.equals(
                                    locationUser.country,
                                    ignoreCase = true,
                                )
                            ) {
                                if (locationStringBuilder.isNotEmpty()) {
                                    locationStringBuilder.append(" ")
                                }
                                locationStringBuilder.append(locationUser.city)
                            }

                            if (!locationUser.name.isNullOrEmpty() && !locationUser.name.equals(
                                    locationUser.country,
                                    ignoreCase = true,
                                ) && !locationUser.name.equals(locationUser.city, ignoreCase = true)
                            ) {
                                if (locationStringBuilder.isNotEmpty()) {
                                    locationStringBuilder.append(" ")
                                }
                                locationStringBuilder.append(locationUser.name)
                            }

                            if (locationStringBuilder.isNotEmpty()) {
                                txtLocation.text = locationStringBuilder.toString()
                            } else {
                                txtLocation.isVisible = false
                            }
                        }
                        // Counts
                        likesTxt.text = data.likes?.separating()
                        viewsTxt.text = data.views?.separating()
                        downloadsTxt.text = data.downloads?.separating()
                    }
                }
            }
        }
    }
}
