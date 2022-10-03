package com.wordpress.lochindev.a13_maktab.fragment

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.wordpress.lochindev.a13_maktab.R
import kotlinx.android.synthetic.main.fragment_aloqa.*


class AloqaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_aloqa, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        aloqa_call.setOnClickListener {
            val intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:"+"+998939903006")
            startActivity(intent)
//            if (ActivityCompat.checkSelfPermission(requireActivity(),android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        }

        aloqa_mail.setOnClickListener {
            val intent=Intent(Intent.ACTION_SEND)
            intent.data=Uri.parse("Email")
            val aa = arrayOf("urol1980@gmail.com","lbek458@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL,aa)
            intent.putExtra(Intent.EXTRA_SUBJECT,"Assalomu Alaykum 13-maktab rahbariyati")
            intent.putExtra(Intent.EXTRA_TEXT,"Sizlarga kattakon rahmat. Hozir men ilova orqali bu elektron pochtaga yetib keldim")
            intent.type ="message/rfc822"
            val create=Intent.createChooser(intent,"Send Email")
            startActivity(create)

        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AloqaFragment().apply {

            }
    }
}