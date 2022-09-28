package com.wordpress.lochindev.a13_maktab.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.wordpress.lochindev.a13_maktab.R
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

        btn_maktab_haqida.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_maktabHomeFragment_to_maktabHaqidaFragment)

        }


    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MaktabHomeFragment().apply {

            }
    }
}