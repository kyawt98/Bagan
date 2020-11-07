package com.kyawt.baganmap.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.exts.bindView
import com.kyawt.baganmap.view.viewholder.HotelViewHolder

class HotelAdapter (): RecyclerView.Adapter<HotelViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        return HotelViewHolder(parent.context.bindView(R.layout.sub_item_hotel,parent))
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}