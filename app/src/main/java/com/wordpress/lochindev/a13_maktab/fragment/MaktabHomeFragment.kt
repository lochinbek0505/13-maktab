package com.wordpress.lochindev.a13_maktab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.BolimlarAdapter
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import kotlinx.android.synthetic.main.fragment_items.*
import kotlinx.android.synthetic.main.fragment_maktab_home.*

class MaktabHomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maktab_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btn_maktab_haqida.setOnClickListener {
//
//            Navigation.findNavController(view).navigate(R.id.action_maktabHomeFragment_to_maktabHaqidaFragment)
//
//        }

        val bolimlar_list= arrayListOf<Bolimlar_data>(
            Bolimlar_data(1,"Maktab haqida"),
            Bolimlar_data(2,"Yangiliklar"),
            Bolimlar_data(3,"Me'yoriy hujjatlar")
            )

        val adapter= BolimlarAdapter(bolimlar_list,object: BolimlarAdapter.ItemSetOnClickListener{
            override fun onClick(data: Bolimlar_data) {
                when(data.id){

                    1->{
                        Navigation.findNavController(view).navigate(R.id.action_maktabHomeFragment_to_maktabHaqidaFragment)
                    }
                    2->{
                        Navigation.findNavController(view).navigate(R.id.yangiliklar2)

                    }
                    3->{
                        Navigation.findNavController(view).navigate(R.id.action_maktabHomeFragment_to_hujjatlarFragment)

                    }

                }
            }
        })

        maktab_recycyler.adapter=adapter

    }

    private fun fragments(id:Int){



    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaktabHomeFragment().apply {

            }
    }
}