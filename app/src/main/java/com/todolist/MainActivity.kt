package com.todolist

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        setupBottomNavigationView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.home -> {
                val navController = findNavController(R.id.nav_host_fragment_content_main)
                navController.navigate(R.id.NavCadastrarFragment)
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun setupBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navegarParaListaTarefas()
                    true
                }

                R.id.recompensas -> {
                    navegarParaRecompensas()
                    true
                }

                else -> false
            }
        }
    }

    private fun navegarParaListaTarefas() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.ListarFragment)
    }

    private fun navegarParaRecompensas() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.Recompensas)
    }

    private fun navegarParaCadastroTarefa() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.NavCadastrarFragment)
    }
}