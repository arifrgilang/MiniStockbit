package com.arifrgilang.ministockbit.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.arifrgilang.ministockbit.R
import com.arifrgilang.ministockbit.base.BaseBindingActivity
import com.arifrgilang.ministockbit.databinding.ActivityMainBinding
import com.arifrgilang.ministockbit.util.Constant
import com.arifrgilang.ministockbit.util.gone
import com.arifrgilang.ministockbit.util.visible
import com.orhanobut.hawk.Hawk

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {
    private lateinit var navHostFragment: NavHostFragment
    private var isMenuHidden = false

    override fun contentView(): Int = R.layout.activity_main

    override fun setupData(savedInstanceState: Bundle?) {}

    override fun setupView() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            binding.bottomNavigationBar,
            navHostFragment.navController
        )

        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.watchlistFragment,
                R.id.datafeedFragment,
                R.id.loginFragment
            )
        )

        setupActionBarWithNavController(navHostFragment.navController, appBarConfiguration)
    }

    fun hideBottomNavBar() {
        binding.bottomNavigationBar.gone()
    }

    fun showBottomNavBar() {
        binding.bottomNavigationBar.visible()
    }

    fun setMenuHidden(state: Boolean) {
        isMenuHidden = state
        invalidateOptionsMenu()
    }

    private fun showLogoutDialog() {
        LogoutDialogFragment(
                object: LogoutDialogFragment.DialogCallback {
                    override fun isAgree() { logout() }
                }
        ).show(supportFragmentManager, "Logout Dialog")
    }

    private fun logout() {
        Hawk.delete(Constant.USER_TOKEN)
        navHostFragment.findNavController().navigate(R.id.loginFragment, null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        if (isMenuHidden) menu?.findItem(R.id.log_out)?.isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.log_out -> showLogoutDialog()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val navigationController = navHostFragment.findNavController()
        val currentDestId = navigationController.currentDestination?.id
        if (currentDestId == R.id.watchlistFragment || currentDestId == R.id.loginFragment) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}