package com.kyawt.baganmap.view.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.kyawt.baganmap.R
import com.kyawt.baganmap.view.exts.bindView
import com.kyawt.baganmap.view.ui.bottomNav.ArticleFragment
import com.kyawt.baganmap.view.viewholder.ArticleViewHolder




class ArticleAdapter (): RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(parent.context.bindView(R.layout.item_article,parent))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
