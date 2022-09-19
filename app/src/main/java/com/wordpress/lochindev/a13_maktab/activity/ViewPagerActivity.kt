package com.wordpress.lochindev.a13_maktab.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.adapter.ViewPagerAdapter
import com.wordpress.lochindev.a13_maktab.model.viewpager_model
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    private val viewPagerAdapter = ViewPagerAdapter(
        listOf(
            viewpager_model(1),
            viewpager_model(2),
            viewpager_model(3)
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewpager2.adapter=viewPagerAdapter
        setupIndicators()
        viewpager2.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setupCurrentIndicators(position)
            }

        })

        btn_keyingi.setOnClickListener{

            if(viewpager2.currentItem + 1 < viewPagerAdapter.itemCount){
                viewpager2.currentItem += 1
            }
            else{
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }

        }

    }

    private fun setupIndicators(){

        val indecators= arrayOfNulls<ImageView>(viewPagerAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams=
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indecators.indices){

            indecators[i]= ImageView(applicationContext)
            indecators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indikator_inactive
                    )
                )

                this?.layoutParams =layoutParams


            }
            viewpager_contaener.addView(indecators[i])

        }

    }

    private fun setupCurrentIndicators(index:Int){

        val childCount=viewpager_contaener.childCount

        for(i in 0 until childCount){

            val imageView=viewpager_contaener[i] as ImageView

            if(i==index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indikator_active
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indikator_inactive
                    )
                )
            }
        }

    }

}