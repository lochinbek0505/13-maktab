package com.wordpress.lochindev.a13_maktab.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.wordpress.lochindev.a13_maktab.model.Statitika_model

class HomeRepository {

    private val mFirestore = FirebaseFirestore.getInstance()


    fun getStatistika(error:MutableLiveData<String>,statistika:MutableLiveData<Statitika_model>){

        mFirestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()

        mFirestore
            .collection("Umumiy").document("Statistika")
            .get()
            .addOnSuccessListener {
                    documentSnapshot->
                // Document found in the offline cache
//                Log.d("TAG", "Cached document data: ${task.}")

                Log.e("TAG",documentSnapshot.data.toString())
                if (documentSnapshot != null) {
                    statistika.value = documentSnapshot.toObject(Statitika_model::class.java)!!
                }

            }.addOnFailureListener {
                    error.value=it.toString()
            }


    }

}