
package com.kyawt.baganmap

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.google.android.material.tabs.TabLayout
import me.ibrahimsn.lib.SmoothBottomBar

open class BaseActivity : AppCompatActivity() {

  private lateinit var sharedPreferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
  }

  override fun onResume() {
    super.onResume()
    setBackgroundColor()
  }
  /** set background color from DefaultSharedPreferences(PreferenceScreen)  */
  private fun setBackgroundColor() {
    val home = findViewById<View>(R.id.layoutHome)
    home?.setBackgroundColor(
      sharedPreferences.getInt(
        getString(R.string.BackgroundColorPickerPreference),
        ContextCompat.getColor(baseContext, R.color.background)
      )
    )

    val appBar = findViewById<CardView>(R.id.cardAppBar)
    appBar?.setCardBackgroundColor(
      sharedPreferences.getInt(
        getString(R.string.BackgroundColorPickerPreference),
        ContextCompat.getColor(baseContext, R.color.background)
      )
    )

    val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
    tabLayout?.setBackgroundColor(
      sharedPreferences.getInt(
        getString(R.string.BackgroundColorPickerPreference),
        ContextCompat.getColor(baseContext, R.color.background)
      )
    )

    val bottomNav = findViewById<SmoothBottomBar>(R.id.bottomNav)
    bottomNav?.setBackgroundColor(
      sharedPreferences.getInt(
        getString(R.string.BackgroundColorPickerPreference),
        ContextCompat.getColor(baseContext, R.color.background)
      )
    )
    val contact = findViewById<View>(R.id.layoutContact)
    contact?.setBackgroundColor(
      sharedPreferences.getInt(
        getString(R.string.BackgroundColorPickerPreference),
        ContextCompat.getColor(baseContext, R.color.background)
      )
    )
  }
}
