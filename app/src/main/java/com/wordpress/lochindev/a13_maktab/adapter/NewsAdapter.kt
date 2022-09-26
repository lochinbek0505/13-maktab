package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.databinding.ItemsLayoutBinding
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import com.wordpress.lochindev.a13_maktab.model.News_data
import kotlinx.android.synthetic.main.items_layout.view.*
import kotlinx.android.synthetic.main.news_item_layout.view.*

class NewsAdapter(var items: ArrayList<News_data>, var listener: ItemSetOnClickListener) :
    RecyclerView.Adapter<NewsAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: News_data)
    }

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        if(position==0)
        holder.itemView.news_item_layout.setBackgroundResource(R.drawable.item_baground1)

        if(position==1){
            holder.itemView.news_item_layout.setBackgroundResource(R.drawable.item_baground2)
            holder.itemView.first_text.text=""
        }
        if(position==2){
            holder.itemView.news_item_layout.setBackgroundResource(R.drawable.item_baground3)
            holder.itemView.first_text.text=""
        }
        if(position==3){
            holder.itemView.news_item_layout.setBackgroundResource(R.drawable.item_baground4)
            holder.itemView.first_text.text=""
        }
        if(position==4){
            holder.itemView.news_item_layout.setBackgroundResource(R.drawable.item_baground5)
            holder.itemView.first_text.text=""
        }
        holder.itemView.tv_item_news.text = item.name
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }

    }

    override fun getItemCount(): Int = items.count()


}