package com.wordpress.lochindev.a13_maktab.screen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.RahbariyatAdapter
import com.wordpress.lochindev.a13_maktab.model.rahbariyat_data
import com.wordpress.lochindev.a13_maktab.screen.viewmodel.HomeFragmentViewModel
import com.wordpress.lochindev.a13_maktab.screen.viewmodel.RahbariyatActivityViewModel
import kotlinx.android.synthetic.main.activity_rahbariyat_screen.*

class RahbariyatScreenActivity : AppCompatActivity() {

    lateinit var viewModel: RahbariyatActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rahbariyat_screen)

        viewModel = ViewModelProvider(this).get(RahbariyatActivityViewModel::class.java)

        viewModel.error.observe(this, {


//            Toast.makeText(this, it, Toast.LENGTH_LONG).show()

        })

        viewModel.members.observe(this, {

            loadMembers(it)

        })

        loadMb()

        tb_rahbariyat_screen.setOnClickListener {

            finish()


        }

    }

    fun loadMb() {

        viewModel.getMembers()

    }

    fun loadMembers(members_array: ArrayList<rahbariyat_data>) {

        val adapter =
            RahbariyatAdapter(members_array)

        rv_rahbariyat.adapter = adapter

    }

}