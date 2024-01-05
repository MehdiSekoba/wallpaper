package com.mehdisekoba.wallpaper.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mehdisekoba.wallpaper.R
import com.mehdisekoba.wallpaper.databinding.ActivityMainBinding
import com.mehdisekoba.wallpaper.ui.about.AboutFragment
import com.mehdisekoba.wallpaper.ui.download.DownloadFragment
import com.mehdisekoba.wallpaper.utils.NUMBER_FOR
import com.mehdisekoba.wallpaper.utils.NUMBER_ONE
import com.mehdisekoba.wallpaper.utils.NUMBER_THREE
import com.mehdisekoba.wallpaper.utils.base.BaseActivity
import com.mehdisekoba.wallpaper.utils.extensions.setStatusBarIconsColor
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.iconRes
import com.mikepenz.materialdrawer.model.interfaces.nameRes
import com.mikepenz.materialdrawer.util.addItems
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    // Binding
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    // other
    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Transparent status bar
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            statusBarColor = Color.TRANSPARENT
            // Change color of status bar icons
            setStatusBarIconsColor(true)
        }
        // Init nav host
        navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        // Bottom nav menu
        binding.mainBottomNav.apply {
            setupWithNavController(navHost.navController)
            this.disableTooltip()
        }
        // Gone bottom menu
        navHost.navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                when (destination.id) {
                    R.id.homeFragment -> mainBottomNav.isVisible = true
                    R.id.collectionsFragment -> mainBottomNav.isVisible = true
                    R.id.randomFragment -> mainBottomNav.isVisible = true
                    else -> mainBottomNav.isVisible = false
                }
            }
        }
        // materialdrawer
        binding.apply {
            root.setStatusBarBackgroundColor(
                ContextCompat.getColor(
                    this@MainActivity,
                    R.color.transparent,
                ),
            )
            // MaterialDrawer Item
            slider.apply {
                setPadding(0, 60, 0, 0)
                addItems(
                    PrimaryDrawerItem().apply {
                        nameRes = R.string.my_download; iconRes =
                            R.drawable.download; isSelectable = false; identifier = NUMBER_ONE
                    },
                    DividerDrawerItem(),
                    PrimaryDrawerItem().apply {
                        nameRes = R.string.rate_this_app; iconRes = R.drawable.rate; isSelectable =
                            false; identifier = NUMBER_THREE
                    },
                    PrimaryDrawerItem().apply {
                        nameRes = R.string.about; iconRes = R.drawable.about; isSelectable =
                            false; identifier = NUMBER_FOR
                    },
                )
                // close the drawer
                drawerLayout?.closeDrawer(slider)
                drawerLayout
                systemUIVisible = false
                onDrawerItemClickListener = { _, drawerItem, _ ->

                    when (drawerItem.identifier) {
                        NUMBER_ONE -> {
                            replaceFragment(DownloadFragment())
                        }
                        NUMBER_FOR -> {
                            replaceFragment(AboutFragment())
                        }
                    }
                    false
                }
            }
        }
    }
    override fun onNavigateUp(): Boolean {
        return navHost.navController.navigateUp() || super.onNavigateUp()
    }

    fun openCloseNavigationDrawer(view: View) {
        binding.apply {
            if (root.isDrawerOpen(GravityCompat.START)) {
                root.closeDrawer(GravityCompat.START)
            } else {
                root.openDrawer(GravityCompat.START)
            }
        }
    }

    private fun BottomNavigationView.disableTooltip() {
        val content: View = getChildAt(0)
        if (content is ViewGroup) {
            content.forEach {
                it.setOnLongClickListener {
                    return@setOnLongClickListener true
                }
                // disable vibration also
                it.isHapticFeedbackEnabled = false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHost, fragment)
            .addToBackStack(null)
            .commit()
    }
    fun setBottomNavigationVisibility(visibility: Int) {
        binding.mainBottomNav.visibility = visibility
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
