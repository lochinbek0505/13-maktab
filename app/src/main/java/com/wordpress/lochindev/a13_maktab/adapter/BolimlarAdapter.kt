package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.databinding.ItemsLayoutBinding
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import kotlinx.android.synthetic.main.items_layout.view.*

class BolimlarAdapter(var items: ArrayList<Bolimlar_data>, var listener: ItemSetOnClickListener) :
    RecyclerView.Adapter<BolimlarAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: Bolimlar_data)
    }

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_layout, parent, false)
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.itemView.tv_items.text = item.name

        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }

    }

    override fun getItemCount(): Int = items.count()


}