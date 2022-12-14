package com.wordpress.lochindev.a13_maktab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.slayd_holder.view.*

class ImageView_slayd_adapter(
    private val imageList: ArrayList<Int>,
    private val viewPager2: ViewPager2
) : RecyclerView.Adapter<ImageView_slayd_adapter.ImageViewHolder>() {
    class ImageViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imageView:
                ImageView = itemView.findViewById(R.id.iv_Image);
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.slayd_holder, parent, false
            )
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ImageViewHolder,
        position: Int
    ) {
        holder.imageView.setImageResource(imageList[position])
        if (position == imageList.size - 1) {
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    private val runnable = Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }
}