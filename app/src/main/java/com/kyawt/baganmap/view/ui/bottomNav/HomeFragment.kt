package com.kyawt.baganmap.view.ui.bottomNav

import android.animation.ObjectAnimator
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.custom.sliderimage.logic.SliderImage
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    lateinit var supportActionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        setupCards()
        setupImageSlider()
    }


    private fun setupCards() {
        cardPagoda.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_pagodaFragment, null,
                navOptions()
            )
        }
        cardHotel.setOnClickListener {
            findNavController().navigate(
                R.id.action_homeFragment_to_hotelFragment, null,
                navOptions()
            )
        }
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
}

private fun navOptions() = NavOptions.Builder()
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
    .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
    .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
    .build()


