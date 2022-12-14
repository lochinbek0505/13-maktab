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
import com.wordpress.lochindev.a13_maktab.model.rahbariyat_data
import kotlinx.android.synthetic.main.items_layout.view.*
import kotlinx.android.synthetic.main.media_item_layout.view.*
import kotlinx.android.synthetic.main.rahbariyat_item_layout.view.*

class RahbariyatAdapter(var items: ArrayList<rahbariyat_data>) :
    RecyclerView.Adapter<RahbariyatAdapter.Holder>() {
    

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
         return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.rahbariyat_item_layout, parent, false)
        )


    }
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.itemView.tv_ril_bio.text=item.bio

        holder.itemView.tv_ril_lavozim.text=item.level

        holder.itemView.tv_ril_name.text=item.name

        Glide.with(holder.itemView.context).load(item.image).into(holder.itemView.iv_ril)




    }

    override fun getItemCount(): Int = items.count()


}