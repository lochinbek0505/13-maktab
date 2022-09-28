package com.wordpress.lochindev.a13_maktab.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.activity.MaktabActivity
import com.wordpress.lochindev.a13_maktab.activity.OquvchilargaActivity
import com.wordpress.lochindev.a13_maktab.activity.RahbariyatActivity
import com.wordpress.lochindev.a13_maktab.activity.YutuqlarActivity
import com.wordpress.lochindev.a13_maktab.adapter.ImageView_slayd_adapter
import com.wordpress.lochindev.a13_maktab.adapter.NewsAdapter
import com.wordpress.lochindev.a13_maktab.model.News_data
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    lateinit var items_data: ArrayList<News_data>
    lateinit var items_adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)

        val images= listOf(R.drawable.ic_corousel_image_1,R.drawable.ic_header2)
        val adapter= ImageView_slayd_adapter(images)
        view.galeriya.adapter=adapter

        view.galeriya.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){



        })
        items_data = arrayListOf(
            News_data(1, "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Maktab",""),
            News_data(2, "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Raxbariyat",""),
            News_data(3, "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Yutuqlar",""),
            News_data(4, "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,O'quvchilarga",""),
            News_data(5, "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,O'quvchilarga","")

        )
        items_adapter= NewsAdapter(items_data,object:NewsAdapter.ItemSetOnClickListener{
            override fun onClick(data: News_data) {
                Toast.makeText(requireActivity(),data.name,Toast.LENGTH_LONG).show()
            }
        })
        view.news_recycyler.adapter=items_adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        home_maktab.setOnClickListener{
            startActivity(Intent(requireActivity(),MaktabActivity::class.java))
        }

        home_rahbariyat.setOnClickListener{
            startActivity(Intent(requireActivity(),RahbariyatActivity::class.java))
        }

        home_yutuqlar.setOnClickListener{
            startActivity(Intent(requireActivity(),YutuqlarActivity::class.java))
        }

        home_oquvchilarga.setOnClickListener{
            startActivity(Intent(requireActivity(),OquvchilargaActivity::class.java))
        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
            }
    }




}



//        items_data = arrayListOf(
//            Bolimlar_data(1, "Maktab"),
//            Bolimlar_data(2, "Raxbariyat"),
//            Bolimlar_data(3, "Yutuqlar"),
//            Bolimlar_data(1, "O'quvchilarga")
//        )
//        items_adapter = BolimlarAdapter(items_data, object :BolimlarAdapter.ItemSetOnClickListener {
//            override fun onClick(data: Bolimlar_data) {
//                Toast.makeText(activity,data.name,Toast.LENGTH_LONG).show()
//            }
//
//        })
//
//        view.bolimlar_recycler.adapter = items_adapter