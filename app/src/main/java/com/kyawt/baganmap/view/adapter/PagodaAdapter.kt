package com.kyawt.baganmap.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.exts.bindView
import com.kyawt.baganmap.view.viewholder.HotelViewHolder

import com.kyawt.baganmap.view.viewholder.PagodaViewHolder

class PagodaAdapter (): RecyclerView.Adapter<PagodaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagodaViewHolder {
        return PagodaViewHolder(parent.context.bindView(R.layout.item_pagoda,parent))
    }

    override fun onBindViewHolder(holder: PagodaViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
