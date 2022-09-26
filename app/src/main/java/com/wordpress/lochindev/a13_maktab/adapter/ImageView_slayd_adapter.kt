package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.slayd_holder.view.*

class ImageView_slayd_adapter(private val images:List<Int>): RecyclerView.Adapter<ImageView_slayd_adapter.VIewHolder>() {
    inner class VIewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VIewHolder {
        return VIewHolder(LayoutInflater.from(parent.context).inflate(R.layout.slayd_holder,parent,false))
    }

    override fun onBindViewHolder(holder: VIewHolder, position: Int) {
        val image=images[position]
        holder.itemView.iv_Image.setImageResource(image)
    }

    override fun getItemCount(): Int {
        return images.count()
    }
}