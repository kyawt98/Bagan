package com.kyawt.baganmap.view.ui.home.hotel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyawt.baganmap.R
import com.skydoves.indicatorscrollview.IndicatorAnimation
import com.skydoves.indicatorscrollview.IndicatorItem
import com.skydoves.indicatorscrollview.indicatorItem
import kotlinx.android.synthetic.main.fragment_hotel.*
import kotlinx.android.synthetic.main.fragment_hotel.indicatorView
import kotlinx.android.synthetic.main.fragment_hotel.popularLayout
import kotlinx.android.synthetic.main.fragment_hotel_detail.*

class HotelDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addIndicator()
    }

    private fun addIndicator() {
        scrollableLayout.bindIndicatorView(indicatorViewDetail)
        indicatorViewDetail + indicatorItem(topStarLayout) {
            setItemColorResource(R.color.colorPrimary)
            setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
            setItemCornerRadius(30f)
        }

        indicatorViewDetail + IndicatorItem.Builder(recyclerHotelImg)
            .setItemColorResource(R.color.cherry)
            .setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
            .setItemCornerRadius(30f)
            .build()

        indicatorViewDetail.addIndicatorItem(
            IndicatorItem.Builder(cardHotelName)
                .setItemColorResource(R.color.colorAccent)
                .setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
                .setItemCornerRadius(30f)
                .build()
        )

        indicatorViewDetail.addIndicatorItem(
            IndicatorItem.Builder(cardRoom)
                .setItemColorResource(R.color.md_blue_100)
                .setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
                .setItemCornerRadius(30f)
                .build()
        )

        indicatorViewDetail.addIndicatorItem(
            IndicatorItem.Builder(cardAddress)
                .setItemColorResource(R.color.md_yellow_200)
                .setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
                .setItemCornerRadius(30f)
                .build()
        )

        indicatorViewDetail.addIndicatorItem(
            IndicatorItem.Builder(cardFacilities)
                .setItemColorResource(R.color.md_green_100)
                .setIndicatorAnimation(IndicatorAnimation.ACCELERATE)
                .setItemCornerRadius(30f)
                .build()
        )
    }

}