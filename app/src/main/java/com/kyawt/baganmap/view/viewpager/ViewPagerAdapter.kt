package com.kyawt.baganmap.view.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kyawt.baganmap.view.ui.home.hotel.HotelFragment
import com.kyawt.baganmap.view.ui.home.pagoda.PagodaFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                // # Pagoda Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Pagoda")
                val pagodaFragment = PagodaFragment()
                pagodaFragment.arguments = bundle
                return pagodaFragment
            }
            1 -> {
                // # Hotel Fragment
                val bundle = Bundle()
                bundle.putString("fragmentName", "Hotel")
                val hotelFragment = HotelFragment()
                hotelFragment.arguments = bundle
                return hotelFragment
            }
            else -> return PagodaFragment()
        }
    }

    override fun getItemCount(): Int {
        return numberOfTabs
    }
}