package com.kyawt.baganmap.view.ui.home.pagoda

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatEditText
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kyawt.baganmap.R
import com.yalantis.jellytoolbar.listener.JellyListener
import kotlinx.android.synthetic.main.edit_text.*
import kotlinx.android.synthetic.main.fragment_about.*
import kotlinx.android.synthetic.main.fragment_hotel.*
import kotlinx.android.synthetic.main.fragment_pagoda.*

class PagodaFragment : Fragment() {
    private var TEXT_KEY : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        onBackPressed()
        setupToolbar()
    }

    private fun setupRecycler(){

    }
    private fun setupToolbar() {
        toolBarpagoda.jellyListener = object : JellyListener() {
            override fun onCancelIconClicked() {
                if (TextUtils.isEmpty(etSearch?.text)) {
                    toolBarpagoda.collapse()
                } else {
                    etSearch?.text?.clear()
                }
            }
        }
        toolBarpagoda.toolbar?.setPadding(0, getStatusBarHeight(), 0, 16)
        val etd = LayoutInflater.from(context).inflate(R.layout.edit_text, null) as AppCompatEditText
        etd.setBackgroundResource(R.color.colorTransparent)
        toolBarpagoda.contentView = etd
    }
    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TEXT_KEY, etSearch.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            etSearch.setText(savedInstanceState.getString(TEXT_KEY))
            etSearch.setSelection(etSearch.text!!.length)
        }
    }

    private fun onBackPressed() {
//        icBack.setOnClickListener {
//            findNavController().navigate(
//                R.id.action_pagodaFragment_to_homeFragment,
//                null,
//                navOptions()
//            )
//        }
    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()

}