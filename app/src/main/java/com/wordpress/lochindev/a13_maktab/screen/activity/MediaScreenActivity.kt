package com.wordpress.lochindev.a13_maktab.screen.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.model.media_data
import kotlinx.android.synthetic.main.activity_media_screen.*
import kotlinx.android.synthetic.main.media_item_layout.view.*

class MediaScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_screen)

        tb_meadia_screen.setOnClickListener{

            finish()

        }

        val media=intent.getSerializableExtra("MEDIA") as media_data?
        displayShow(media as media_data)

    }
    fun displayShow(media:media_data){

        Glide.with(this@MediaScreenActivity).load(media.image).into(iv_ams)
        tv_toolbar_ams.text=media.title
        tv_title_ams.text=media.title
        tv_text_ams.text=media.text
        tv_data_ams.text=media.data


    }
}