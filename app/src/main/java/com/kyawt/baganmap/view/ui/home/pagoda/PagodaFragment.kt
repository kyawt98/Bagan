package com.kyawt.baganmap.view.ui.home.pagoda

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import androidx.fragment.app.Fragment
=======
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
>>>>>>> 79ca798f489e3ef8291712f5269f230e4220eb52
import com.kyawt.baganmap.R
import kotlinx.android.synthetic.main.fragment_about.*

<<<<<<< HEAD
class PagodaFragment : Fragment()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
=======
class PagodaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

>>>>>>> 79ca798f489e3ef8291712f5269f230e4220eb52
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagoda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
    }

    private fun setupRecycler(){
=======
        onBackPressed()
    }
>>>>>>> 79ca798f489e3ef8291712f5269f230e4220eb52

    private fun onBackPressed() {
        icBack.setOnClickListener {
            findNavController().navigate(
                R.id.action_pagodaFragment_to_homeFragment,
                null,
                navOptions()
            )
        }
    }

<<<<<<< HEAD
=======
    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()
>>>>>>> 79ca798f489e3ef8291712f5269f230e4220eb52
}