package com.wordpress.lochindev.a13_maktab.screen.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.google.firebase.firestore.*
import com.wordpress.lochindev.a13_maktab.R
import com.wordpress.lochindev.a13_maktab.screen.activity.*
import com.wordpress.lochindev.a13_maktab.adapter.ImageView_slayd_adapter
import com.wordpress.lochindev.a13_maktab.adapter.NewsAdapter
import com.wordpress.lochindev.a13_maktab.model.News_data
import com.wordpress.lochindev.a13_maktab.model.Statitika_model
import com.wordpress.lochindev.a13_maktab.screen.viewmodel.HomeFragmentViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.lang.Math.abs

class HomeFragment : Fragment() {

    lateinit var items_data: ArrayList<News_data>

    lateinit var items_adapter: NewsAdapter

    private lateinit var handler: Handler

    private lateinit var imageList: ArrayList<Int>

    private lateinit var adapter: ImageView_slayd_adapter

    lateinit var viewModel:HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        items_data = arrayListOf(
            News_data(
                1,
                "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Maktab",
                ""
            ),
            News_data(
                2,
                "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Raxbariyat",
                ""
            ),
            News_data(
                3,
                "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,Yutuqlar",
                ""
            ),
            News_data(
                4,
                "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,O'quvchilarga",
                ""
            ),
            News_data(
                5,
                "Iltimos olib keting,Iltimos olib keting, Maktabga kitob keldi, Maktabga kitob keldi,O'quvchilarga",
                ""
            )

        )
        items_adapter = NewsAdapter(items_data, object : NewsAdapter.ItemSetOnClickListener {
            override fun onClick(data: News_data) {
                Toast.makeText(requireActivity(), data.name, Toast.LENGTH_LONG).show()
            }
        })

        view.news_recycyler.adapter = items_adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        viewModel.error.observe(viewLifecycleOwner,{

            Toast.makeText(requireActivity(),it,Toast.LENGTH_LONG).show()

        })

        viewModel.statistika.observe(viewLifecycleOwner,{
            setText(it)
        })
        loadStatistika()
        btn_home_more.setOnClickListener {

            val intent=Intent(requireActivity(), MediaActivity::class.java)
            intent.putExtra("Activity",1)
            startActivity(intent)

        }

        home_maktab.setOnClickListener {

            startActivity(Intent(requireActivity(), MaktabActivity::class.java))

        }

        home_rahbariyat.setOnClickListener {

            startActivity(Intent(requireActivity(), RahbariyatActivity::class.java))

        }

        home_yutuqlar.setOnClickListener {

            startActivity(Intent(requireActivity(), YutuqlarActivity::class.java))

        }

        home_oquvchilarga.setOnClickListener {

            startActivity(Intent(requireActivity(), OquvchilargaActivity::class.java))

        }

        hf_google_map.setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_binolarFragment)


        }

        id_kundalik.setOnClickListener {

            gotoUri("https://login.kundalik.com/login")

        }
        id_khan.setOnClickListener {

            gotoUri("https://www.xanakademiyasi.uz/")

        }

        id_coders.setOnClickListener {

            gotoUri("https://uzbekcoders.uz/")

        }
        id_edu.setOnClickListener {

            gotoUri("https://edu.uz/uz")

        }
        id_ziyonet.setOnClickListener {

            gotoUri("http://site.ziyonet.uz/uz/login")

        }

        init()
        setUpTransformer()
        galeriya.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 4000)
            }
        })
    }


    fun loadStatistika(){

        viewModel.getStatistika()

    }



    fun setText(a: Statitika_model) {
        tv_beginner.text = a.boshlangichlar
        tv_boys.text = a.bolalar
        tv_upper.text = a.yuqori
        tv_girls.text = a.qizlar
        tv_jami.text = a.jami
        tv_teacher.text = a.oqutuvchilar
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 4000)
    }

    private val runnable = Runnable {
        galeriya.currentItem =
            galeriya.currentItem + 1
    }


    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        galeriya.setPageTransformer(transformer)
    }

    private fun init() {
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()
        imageList.add(R.drawable.ic_for_aloqa)
        imageList.add(R.drawable.ic_viewpager2)
        adapter = ImageView_slayd_adapter(imageList, galeriya)
        galeriya.adapter = adapter
        galeriya.offscreenPageLimit = 3
        galeriya.clipToPadding = false
        galeriya.clipChildren = false
        galeriya.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {

            }
    }

    private fun gotoUri(uri: String) {
        val a: Uri = Uri.parse(uri)
        startActivity(Intent(Intent.ACTION_VIEW, a))
    }
}

