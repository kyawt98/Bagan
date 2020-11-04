package com.kyawt.baganmap.view.ui.home.hotel

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.kyawt.baganmap.R
import com.yalantis.jellytoolbar.listener.JellyListener
import com.yalantis.jellytoolbar.widget.JellyToolbar
import kotlinx.android.synthetic.main.edit_text.*
import kotlinx.android.synthetic.main.fragment_hotel.*

class HotelFragment : Fragment() {
    private var TEXT_KEY : String = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
        setupToolbar()

    }

    private fun setupRecycler() {


    }


    @SuppressLint("InflateParams")
    private fun setupToolbar() {
        toolBar.toolbar?.setNavigationIcon(R.drawable.ic_back)
        toolBar.jellyListener = object : JellyListener() {
            override fun onCancelIconClicked() {
                if (TextUtils.isEmpty(etSearch?.text)) {
                    toolBar.collapse()
                } else {
                    etSearch?.text?.clear()
                }
            }
        }
        toolBar.toolbar?.setPadding(0, getStatusBarHeight(), 0, 0)
        val etd = LayoutInflater.from(context).inflate(R.layout.edit_text, null) as AppCompatEditText
        etd.setBackgroundResource(R.color.colorTransparent)
        toolBar.contentView = etd
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
        icBack.setOnClickListener {
            findNavController().navigate(R.id.action_hotelFragment_to_homeFragment, null,navOptions())
        }
    }

    private fun navOptions() = NavOptions.Builder()
        .setEnterAnim(R.anim.nav_default_enter_anim)
        .setExitAnim(R.anim.nav_default_exit_anim)
        .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
        .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
        .build()
}


