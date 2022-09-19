package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.databinding.ItemsLayoutBinding

class BolimlarAdapter(var list: ArrayList<String>, var listener: ItemOnClickListener) :
    RecyclerView.Adapter<BolimlarAdapter.ItemHolder>() {
    inner class ItemHolder(var binding: ItemsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    interface ItemOnClickListener {

        fun onClick(name: String) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemsLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = list[position]
        holder.binding.tvItems.text = item
        holder.itemView.setOnClickListener {
            listener.onClick(item)
        }

    }

    override fun getItemCount(): Int = list.size
}