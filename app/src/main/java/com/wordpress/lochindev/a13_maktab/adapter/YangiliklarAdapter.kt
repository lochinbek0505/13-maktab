package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.model.yangilik_data
import kotlinx.android.synthetic.main.yangilik_layout.view.*

class YangiliklarAdapter(var items: ArrayList<yangilik_data>, var listener: ItemSetOnClickListener) :
    RecyclerView.Adapter<YangiliklarAdapter.Holder>() {

    interface ItemSetOnClickListener {
        fun onClick(data: yangilik_data)
    }

    inner class Holder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return return Holder(

            LayoutInflater.from(parent.context).inflate(R.layout.yangilik_layout, parent, false)

        )

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]

        holder.itemView.tv_news.text = item.name
        holder.itemView.iv_new_ly.setImageResource(item.image!!)
//        holder.itemView.cv_news_layout.startAnimation(AnimationUtils.loadAnimation(holder.itemView.context,R.anim.items_anim1))
        holder.itemView.setOnClickListener {

            listener.onClick(item)

        }

    }

    override fun getItemCount(): Int = items.count()


}