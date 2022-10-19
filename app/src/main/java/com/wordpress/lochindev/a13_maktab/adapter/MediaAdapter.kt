package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.constants.Constant.TAG
import com.wordpress.lochindev.a13_maktab.databinding.ItemsLayoutBinding
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import com.wordpress.lochindev.a13_maktab.model.media_data
import kotlinx.android.synthetic.main.items_layout.view.*
import kotlinx.android.synthetic.main.media_item_layout.view.*

class MediaAdapter(var items: ArrayList<media_data>, var listener: ItemSetOnClickListener) :
    RecyclerView.Adapter<MediaAdapter.Holder>() {
    
    interface ItemSetOnClickListener {
        fun onClick(data: media_data)
    }

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
         return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.media_item_layout, parent, false)
        )


    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.itemView.tv_mil_text.text = item.text
        holder.itemView.tv_mil_data.text=item.data

        Glide.with(holder.itemView.context).load(item.image).into(holder.itemView.iv_mil)


        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }

    }

    override fun getItemCount(): Int = items.count()


}