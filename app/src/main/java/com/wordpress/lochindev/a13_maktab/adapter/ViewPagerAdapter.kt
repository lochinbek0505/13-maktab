package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.model.viewpager_model

class ViewPagerAdapter(private val index_list:List<viewpager_model>):RecyclerView.Adapter<ViewPagerAdapter.Holder>() {

    inner class  Holder(view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        if (viewType==1) {
            return Holder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.information_viewpager_layout, parent, false)
            )

        }
        if (viewType==2) {
            return Holder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.news_viewpager_layout, parent, false)
            )
        }
        return Holder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.location_viewpager_layout, parent, false)
        )
    }


    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item=index_list[position]
    }

    override fun getItemCount(): Int {
        return index_list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when(index_list[position].index){

            1 ->{
                1
            }
            2 ->{
                2
            }
            else -> {
                3
            }
        }
    }

}
