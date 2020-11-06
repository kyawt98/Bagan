package com.kyawt.baganmap.view.ui.bottomNav

import android.animation.ObjectAnimator
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.preference.PreferenceManager
import com.custom.sliderimage.logic.SliderImage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.viewpager.TabsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import me.ibrahimsn.lib.SmoothBottomBar


class HomeFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabs()
        setupImageSlider()
        scrollableLayout.scheduleLayoutAnimation()
        setupBackgroundColor()
    }

    private fun setupTabs() {
        // Tabs Customization
        tab_layout.setSelectedTabIndicatorColor(Color.WHITE)
        tab_layout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.darkColor))
        tab_layout.tabTextColors = ContextCompat.getColorStateList(requireContext(), android.R.color.white)
        val numberOfTabs = 2
        tab_layout.tabMode = TabLayout.MODE_FIXED
        tab_layout.tabMode = TabLayout.MODE_FIXED
        // Set the ViewPager Adapter
        val adapter = TabsPagerAdapter(requireFragmentManager(), lifecycle, numberOfTabs)
        tabs_viewpager.adapter = adapter

        // Enable Swipe
        tabs_viewpager.isUserInputEnabled = true

        TabLayoutMediator(tab_layout, tabs_viewpager) { tab, position ->
            val pagoda = resources.getString(R.string.pagodas)
            val hotel = resources.getString(R.string.hotels)
            when (position) {
                0 -> {
                    tab.text = pagoda
                }
                1 -> {
                    tab.text = hotel
                }
            }
        }.attach()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setupImageSlider() {
        val sliderImage = SliderImage(requireContext())

        // add images URLs
        val images = listOf(
            "https://www.tripsavvy.com/thmb/R2iiiozTBvbKjIHlnOB_UnOrjKc=/800x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/bagan_balloon-5a2d396daad52b0036876b44.jpg",
            "https://cdn.thecrazytourist.com/wp-content/uploads/2019/04/ccimage-shutterstock_240621838.jpg",
            "https://www.tripsavvy.com/thmb/wiU1gB2Z9Fe_YCuQIiCTQnuhL0k=/800x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/bagan_bike-5a2d3984beba3300370efaf2.jpg",
            "https://cdn.thecrazytourist.com/wp-content/uploads/2019/04/ccimage-shutterstock_795581581.jpg",
            "https://cdn.thecrazytourist.com/wp-content/uploads/2019/04/ccimage-shutterstock_423045388.jpg",
            "https://cdn.thecrazytourist.com/wp-content/uploads/2019/04/ccimage-shutterstock_378628897.jpg"
        )

        // Add image URLs to sliderImage
        slider.setItems(images)
        slider.setAutofillHints("Hot air balloon ride","Check out Shwesandaw Paya","Ride Around Bagan Temple ","Shop at Mani-Sithu Market"," Night Market and Carnival","Take a boat trip")
        slider.addTimerToSlide(5000)
        slider.getIndicator()
    }

    private fun setupBackgroundColor(){
        layoutHome?.setBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )

        cardAppBar?.setCardBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )
        tab_layout?.setBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )

        bottomNav?.setBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )

    }

}



private fun navOptions() = NavOptions.Builder()
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
    .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
    .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
    .build()


