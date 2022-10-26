package com.wordpress.lochindev.a13_maktab.screen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.BolimlarAdapter
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
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
            Bolimlar_data(3,"E'lonlar"),
            Bolimlar_data(4,"Fotogaleriya"),
            Bolimlar_data(5,"Videogaleriya"),
            Bolimlar_data(6,"Me'yoriy hujjatlar")
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
                    6->{
                        Navigation.findNavController(view).navigate(R.id.action_maktabHomeFragment_to_hujjatlarFragment)

                    }

                }
            }
        })

        tb_maktab_home.setOnClickListener {
            activity?.finish()
        }

        maktab_recycyler.adapter=adapter

    }

    private fun fragments(id:Int){



    }

    companion object {

        @JvmStatic
        fun newInstance() =
            MaktabHomeFragment().apply {

            }
    }
}