package com.wordpress.lochindev.a13_maktab.screen.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.MediaAdapter
import com.wordpress.lochindev.a13_maktab.databinding.ActivityMediaBinding
import com.wordpress.lochindev.a13_maktab.model.media_data
import com.wordpress.lochindev.a13_maktab.screen.viewmodel.MediaActivityViewModel
import kotlinx.android.synthetic.main.activity_media.*
import kotlinx.android.synthetic.main.activity_media_screen.*

class MediaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMediaBinding
    private lateinit var viewmodel:MediaActivityViewModel
    private lateinit var news_list:ArrayList<media_data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel=ViewModelProvider(this).get(MediaActivityViewModel::class.java)

        news_list= arrayListOf()

        val activity:Int=intent.extras!!.getInt("Activity")

        media_back.setOnClickListener {
            finish()
        }

        when(activity){

            1 ->{

                binding.tvToolbarMedia.text="Yangiliklar"
                loadNews()

                viewmodel.news.observe(this,{

                    load(it)

                })




            }

        }







    }

    fun load(array:ArrayList<media_data>){
        val adapter=MediaAdapter(array,object:MediaAdapter.ItemSetOnClickListener{
            override fun onClick(data: media_data) {

                val intent= Intent(applicationContext,MediaScreenActivity::class.java)
                intent.putExtra("MEDIA",data)
                startActivity(intent)

            }

        })
        binding.rvMedia.adapter=adapter


    }

    fun loadNews(){

        viewmodel.getnews()

    }

}