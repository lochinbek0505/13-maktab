package com.wordpress.lochindev.a13_maktab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.BolimlarAdapter
import com.wordpress.lochindev.a13_maktab.adapter.NewsAdapter
import com.wordpress.lochindev.a13_maktab.adapter.YangiliklarAdapter
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import com.wordpress.lochindev.a13_maktab.model.News_data
import com.wordpress.lochindev.a13_maktab.model.yangilik_data
import kotlinx.android.synthetic.main.fragment_items.*
import kotlinx.android.synthetic.main.fragment_yangiliklar.view.*


class YangiliklarFragment : Fragment() {

    lateinit var items_data: ArrayList<yangilik_data>
    lateinit var items_adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_yangiliklar, container, false)
        // Inflate the layout for this fragment

        items_data = arrayListOf(
            yangilik_data(1, R.drawable.ic_news_24,"Yangiliklar"),
            yangilik_data(2,R.drawable.ic_elon_icon ,"E'lonlar"),
            yangilik_data(3, R.drawable.ic_baseline_collections_24,"Fotogaleriya"),
            yangilik_data(4, R.drawable.ic_baseline_subscriptions_24,"Videogaleriya")
        )

        val adapter =
            YangiliklarAdapter(items_data, object : YangiliklarAdapter.ItemSetOnClickListener {

                override fun onClick(data: yangilik_data) {


                }

            })

        view.yangiliklar_recyclerview.adapter = adapter
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            YangiliklarFragment().apply {

            }
    }
}
