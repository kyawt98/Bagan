package com.kyawt.baganmap.view.viewpager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kyawt.baganmap.view.ui.home.AdvertisingFragment
import com.kyawt.baganmap.view.ui.home.HotelFragment
import com.kyawt.baganmap.view.ui.home.PagodaFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                PagodaFragment.newInstance()
            }

            1 -> {
                HotelFragment()
            }

            else -> {
                return AdvertisingFragment()
            }
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Pagoda"
            1 -> "Hotel"
            else ->{
                return "Advertising"
            }
        }
    }
}