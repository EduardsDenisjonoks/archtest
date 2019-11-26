package com.exail.archtest.bottom

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.exail.archtest.R
import com.exail.archtest.core.base.BaseActivity
import com.exail.archtest.databinding.ActivityBottomNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavActivity : BaseActivity() {

    private val navController: NavController
        get() {
            return findNavController(R.id.nav_host_fragment)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityBottomNavBinding>(
            this,
            R.layout.activity_bottom_nav
        )

        initActionBat(binding.toolbar)
        initBottomNav(binding.navView)

    }

    private fun initActionBat(toolbar: Toolbar) {
        toolbar.setupWithNavController(navController)
    }

    private fun initBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.setupWithNavController(navController)
    }
}
