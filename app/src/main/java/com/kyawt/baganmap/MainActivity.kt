package com.kyawt.baganmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.kyawt.baganmap.view.exts.gone
import com.kyawt.baganmap.view.exts.visible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.container)
        setupActionBarWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.hide()

            if (destination.id == R.id.aboutFragment) {
                bottomNav.gone()
            } else {
                bottomNav.visible()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navController = findNavController(R.id.container)
        menuInflater.inflate(R.menu.menu, menu)
        bottomNav.setupWithNavController(menu!!, navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }


}