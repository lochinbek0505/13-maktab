package com.wordpress.lochindev.a13_maktab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.NewsAdapter
import com.wordpress.lochindev.a13_maktab.model.News_data
import kotlinx.android.synthetic.main.fragment_yangiliklar.view.*


class YangiliklarFragment : Fragment() {

    lateinit var items_data: ArrayList<News_data>
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
            News_data(1, "Maktab",""),
            News_data(2, "Raxbariyat",""),
            News_data(3, "Yutuqlar",""),
            News_data(1, "O'quvchilarga","")
        )


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            YangiliklarFragment().apply {
            }
    }
}
