package com.kyawt.baganmap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kyawt.baganmap.Model.article
import com.kyawt.baganmap.R
import java.util.*


class articleAdapter(//  private List<detail> detailItems;
    private val listener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<articleAdapter.ArticleViewHolder>() {
    private lateinit var listItems: List<article>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(itemView)
    }

   /* override fun onBindViewHolder(
        holder: ItemViewHolder,
        position: Int
    ) {
        val item: Item = listItems[position]
        holder.bind(item)
    }*/

    fun setItems(items: List<article>) {
        listItems = items
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    interface RecyclerViewClickListener {
        fun onClick(item: article?)
    }

    inner class ArticleViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val id: TextView
        private val name: TextView
        private val username: TextView
        fun bind(item: article) {
            id.setText(item.getID())
            name.setText(item.getName())
            username.setText(item.getUsername())
            itemView.rootView.setOnClickListener { listener.onClick(item) }
        }

        init {
            id = itemView.findViewById<View>(R.id.id) as TextView
            name = itemView.findViewById<View>(R.id.name) as TextView
            username = itemView.findViewById<View>(R.id.username) as TextView
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item: article = listItems[position]
        holder.bind(item)    }

    /* init {
         listItems = ArrayList<Item>()
         //  this.detailItems=new ArrayList<>();
     }*/
}
