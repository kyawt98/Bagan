package com.kyawt.baganmap.view.viewpager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kyawt.baganmap.view.ui.home.advertising.AdvertisingFragment
import com.kyawt.baganmap.view.ui.home.hotel.HotelFragment
import com.kyawt.baganmap.view.ui.home.pagoda.PagodaFragment
import com.kyawt.baganmap.view.ui.home.promotion.PromotionFragment

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

            2 -> {
                PromotionFragment()
            }

            else -> {
                return AdvertisingFragment()
            }
        }
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Pagoda"
            1 -> "Hotel"
            2 -> "Promotion"
            else ->{
                return "Advertising"
            }
        }
    }
}