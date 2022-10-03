package com.wordpress.lochindev.a13_maktab.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.activity.MaktabActivity
import com.wordpress.lochindev.a13_maktab.activity.OquvchilargaActivity
import com.wordpress.lochindev.a13_maktab.activity.RahbariyatActivity
import com.wordpress.lochindev.a13_maktab.activity.YutuqlarActivity
import com.wordpress.lochindev.a13_maktab.adapter.BolimlarAdapter
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import kotlinx.android.synthetic.main.fragment_items.*

class ItemsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bolimlar_list = arrayListOf<Bolimlar_data>(
            Bolimlar_data(1, "Maktab"),
            Bolimlar_data(2, "Rahbariyat"),
            Bolimlar_data(3, "Yutuqlar"),
            Bolimlar_data(4, "O'quvchilarga")
        )

        val adapter =
            BolimlarAdapter(bolimlar_list, object : BolimlarAdapter.ItemSetOnClickListener {

                override fun onClick(data: Bolimlar_data) {

                    fragments(data.id!!)

                }

            })

        items_recycyler.adapter = adapter
//        items_recycyler.animation =
//            AnimationUtils.loadAnimation(requireActivity(), R.anim.items_anim1)

    }

    private fun fragments(id: Int) {

        when (id) {

            1 -> {
                startActivity(Intent(requireActivity(), MaktabActivity::class.java))
            }
            2 -> {
                startActivity(Intent(requireActivity(), RahbariyatActivity::class.java))

            }
            3 -> {
                startActivity(Intent(requireActivity(), YutuqlarActivity::class.java))

            }
            4 -> {
                startActivity(Intent(requireActivity(), OquvchilargaActivity::class.java))

            }

        }

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemsFragment().apply {

            }

    }
}