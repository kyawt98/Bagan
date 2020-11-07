package com.kyawt.baganmap

import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.preference.PreferenceManager
import com.kyawt.baganmap.view.exts.gone
import com.kyawt.baganmap.view.exts.visible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var navController: NavController
    private var sharedPreferences: SharedPreferences? = null
    private var currentLang:String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val shp = getSharedPreferences(
            "CommonPrefs", MODE_PRIVATE
        )
        val language = shp.getString("Language", "en")
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = findNavController(R.id.container)
        setupActionBarWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            supportActionBar?.hide()

            if (destination.id == R.id.aboutFragment || destination.id == R.id.privacyFragment || destination.id == R.id.pagodaFragment || destination.id == R.id.hotelFragment || destination.id == R.id.feedbackFragment) {
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

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        TODO("Not yet implemented")
    }
}