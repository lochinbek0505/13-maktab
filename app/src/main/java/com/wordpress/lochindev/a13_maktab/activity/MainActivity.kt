package com.wordpress.lochindev.a13_maktab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.NewsAdapter
import com.wordpress.lochindev.a13_maktab.model.News_data
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class MainActivity : AppCompatActivity() {

    lateinit var items_data: ArrayList<News_data>
    lateinit var items_adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items_data = arrayListOf(
            News_data(1, "Maktab",""),
            News_data(2, "Raxbariyat",""),
            News_data(3, "Yutuqlar",""),
            News_data(1, "O'quvchilarga","")
        )
        items_adapter= NewsAdapter(items_data,object:NewsAdapter.ItemSetOnClickListener{
            override fun onClick(data: News_data) {
                TODO("Not yet implemented")
            }
        })
//        news_recycylert.adapter=items_adapter
    }
}