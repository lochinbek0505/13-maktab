package com.wordpress.lochindev.a13_maktab.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.*
import com.wordpress.lochindev.a13_maktab.model.Statitika_model
import com.wordpress.lochindev.a13_maktab.model.media_data
import com.wordpress.lochindev.a13_maktab.model.rahbariyat_data

class HomeRepository {

    private val mFirestore = FirebaseFirestore.getInstance()
    private lateinit var rahbariyat_array_list:ArrayList<rahbariyat_data>


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


    fun getRahbariyat(_error:MutableLiveData<String>,array:MutableLiveData<ArrayList<rahbariyat_data>>){

        rahbariyat_array_list= arrayListOf()


        mFirestore.collection("NEWS").orderBy("data", Query.Direction.ASCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if(error!=null){

                    }
                    for(dc: DocumentChange in value?.documentChanges!!){

                        if(dc.type== DocumentChange.Type.ADDED){

                            rahbariyat_array_list.add(dc.document.toObject(rahbariyat_data::class.java))

                        }

                    }

                    array.value=rahbariyat_array_list
                    _error.value=error.toString()


                }

            })



    }

}