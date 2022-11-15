package com.wordpress.lochindev.a13_maktab.screen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.fragment_hujjatlar.*


class HujjatlarFragment : Fragment() {

  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_hujjatlar, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mh_back.setOnClickListener {
            activity?.finish()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HujjatlarFragment().apply {
            }
    }
}