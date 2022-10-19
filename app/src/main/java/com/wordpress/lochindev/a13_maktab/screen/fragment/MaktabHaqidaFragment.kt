package com.wordpress.lochindev.a13_maktab.screen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.fragment_maktab_haqida.*


class MaktabHaqidaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_maktab_haqida, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        tv_toolbar_maktab.text="Maktab haqida"

        tb_maktab_haqida.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_maktabHaqidaFragment_to_maktabHomeFragment)

            activity?.finish()

        }


    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaktabHaqidaFragment().apply {

            }

    }
}