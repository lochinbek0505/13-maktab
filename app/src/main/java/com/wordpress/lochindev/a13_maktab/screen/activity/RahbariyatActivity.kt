package com.wordpress.lochindev.a13_maktab.screen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.BolimlarAdapter
import com.wordpress.lochindev.a13_maktab.model.Bolimlar_data
import kotlinx.android.synthetic.main.activity_rahbariyat.*
import kotlinx.android.synthetic.main.fragment_maktab_home.*

class RahbariyatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rahbariyat)

        val bolimlar_list= arrayListOf<Bolimlar_data>(
            Bolimlar_data(1,"Boshqaruv kengashi"),
            Bolimlar_data(2,"Boshqaruv nizomi")
        )

        tb_rahbariyat.setOnClickListener {

            finish()


        }

        val adapter= BolimlarAdapter(bolimlar_list,object: BolimlarAdapter.ItemSetOnClickListener{
            override fun onClick(data: Bolimlar_data) {
                when(data.id){

                    1->{

                        startActivity(Intent(this@RahbariyatActivity,RahbariyatScreenActivity::class.java))

                    }


                }
            }
        })


        rahbariyat_recycyler.adapter=adapter

    }
}