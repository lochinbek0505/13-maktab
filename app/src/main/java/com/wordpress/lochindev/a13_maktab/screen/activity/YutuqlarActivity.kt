package com.wordpress.lochindev.a13_maktab.screen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.activity_yutuqlar.*

class YutuqlarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yutuqlar)


        tb_yutuqlar.setOnClickListener {


            finish()

        }

    }
}