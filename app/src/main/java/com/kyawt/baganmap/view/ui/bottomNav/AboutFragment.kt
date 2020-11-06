package com.kyawt.baganmap.view.ui.bottomNav

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_about.icBack
import kotlinx.android.synthetic.main.fragment_privacy.*

class AboutFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
        setupBackgroundColor()
    }

    private fun onBackPressed() {
        icBack.setOnClickListener {
            findNavController().navigate(
                R.id.action_aboutFragment_to_settingFragment,
                null,
                navOptions()
            )
        }
    }

    private fun setupBackgroundColor(){
        layoutAbout?.setBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )

        appBarAbout?.setCardBackgroundColor(
            sharedPreferences.getInt(
                getString(R.string.BackgroundColorPickerPreference),
                ContextCompat.getColor(requireContext(), R.color.background)
            )
        )
    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()
}