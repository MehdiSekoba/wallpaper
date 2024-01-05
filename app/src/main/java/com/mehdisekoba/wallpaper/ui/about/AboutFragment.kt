package com.mehdisekoba.wallpaper.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import coil.load
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.FragmentAboutBinding
import com.mehdisekoba.wallpaper.ui.MainActivity
import com.mehdisekoba.wallpaper.utils.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BaseFragment<FragmentAboutBinding>() {
    override val bindingInflater: (inflater: LayoutInflater) -> FragmentAboutBinding
        get() = FragmentAboutBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // initViews
        binding.apply {
            profile.load(R.drawable.profile)
            divider.load(R.drawable.profile_divider)
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
