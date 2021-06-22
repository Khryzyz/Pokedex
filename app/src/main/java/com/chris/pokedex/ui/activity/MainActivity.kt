package com.chris.pokedex.ui.activity

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.chris.pokedex.R
import com.chris.pokedex.databinding.MainActivityBinding
import com.chris.pokedex.utils.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: MainActivityBinding

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = MainActivityBinding.inflate(layoutInflater)

        val view = binding.root

        setContentView(view)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstGenFragment,
                R.id.secondGenFragment,
                R.id.thirdGenFragment,
                R.id.fourthGenFragment
            )
        )

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)

        binding.bottomNavView.setOnNavigationItemSelectedListener(this)

        binding.bottomNavView.itemIconTintList = null

        setOnDestinationChangedListener()
    }


    /**
     * Implementa un escuchador a la navegacion y altera la UI de acuerdo al fragmento usado
     */
    private fun setOnDestinationChangedListener() {

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.firstGenFragment,
                R.id.secondGenFragment,
                R.id.thirdGenFragment,
                R.id.fourthGenFragment ->
                    binding.bottomNavView.visibility = View.VISIBLE
                else ->
                    binding.bottomNavView.visibility = View.GONE
            }
        }
    }


    /**
     * Escuchador del item seleccionado para la navegacion
     */
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.firstGenItem -> navController.navigate(
                R.id.firstGenFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.GENERATION,
                        Constants.Generation.FIRST
                    )
                }
            )
            R.id.secondGenItem -> navController.navigate(
                R.id.secondGenFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.GENERATION,
                        Constants.Generation.SECOND
                    )
                }
            )
            R.id.thirdGenItem -> navController.navigate(
                R.id.thirdGenFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.GENERATION,
                        Constants.Generation.THIRD
                    )
                }
            )
            R.id.fourthGenItem -> navController.navigate(
                R.id.fourthGenFragment,
                Bundle().apply {
                    putSerializable(
                        Constants.BundleKeys.GENERATION,
                        Constants.Generation.FOURTH
                    )
                }
            )
        }

        return true
    }
}