package com.example.mobiledevlabs

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mobiledevlabs.data.SessionManager
import com.example.mobiledevlabs.databinding.ActivityMainBinding
import com.example.mobiledevlabs.utils.LoggingUtils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupNavigation()
        setupAppBar()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Dynamically set the start destination
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        if (sessionManager.isUserLoggedIn()) {
            navGraph.setStartDestination(R.id.homeFragment)
            // If logged in, pass the user to HomeFragment
            val user = sessionManager.getUser()
            if (user != null) {
                val bundle = Bundle()
                bundle.putParcelable("user", user)
                navController.setGraph(navGraph, bundle)
            } else {
                // Handle error: user is logged in but user data is missing
                navGraph.setStartDestination(R.id.onboardFragment)
                navController.setGraph(navGraph)
            }
        } else {
            navGraph.setStartDestination(R.id.onboardFragment)
            navController.setGraph(navGraph)
        }

        // Log transitions
        navController.addOnDestinationChangedListener { _, destination, _ ->
            LoggingUtils.i("Navigated to ${destination.label}")
            // Show/hide AppBar based on the destination
            when (destination.id) {
                R.id.onboardFragment, R.id.signInFragment, R.id.signUpFragment -> {
                    binding.appBarLayout.visibility = View.GONE
                }
                else -> {
                    binding.appBarLayout.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun setupAppBar() {
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
