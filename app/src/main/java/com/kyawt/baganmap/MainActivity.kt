package com.kyawt.baganmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kyawt.baganmap.view.ui.ContactFragment
import com.kyawt.baganmap.view.ui.HomeFragment
import com.kyawt.baganmap.view.ui.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation(){
        navController = findNavController(R.id.container)
        setupActionBarWithNavController(navController)

//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (){
//                bottomNav.visibility = View.GONE
//            }else{
//                bottomNav.visibility = View.VISIBLE
//            }
//        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navController = findNavController(R.id.container)
        menuInflater.inflate(R.menu.menu,menu)
        bottomNav.setupWithNavController(menu!!,navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }


}