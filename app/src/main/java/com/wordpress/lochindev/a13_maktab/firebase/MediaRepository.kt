package com.wordpress.lochindev.a13_maktab.firebase

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.*
import com.wordpress.lochindev.a13_maktab.model.media_data

class MediaRepository {

    private val mFirestore = FirebaseFirestore.getInstance()
    private lateinit var news_array_lis:ArrayList<media_data>
    fun getNews(news:MutableLiveData<ArrayList<media_data>>,_error:MutableLiveData<String>){

        news_array_lis= arrayListOf()


        mFirestore.collection("NEWS").orderBy("data", Query.Direction.ASCENDING)
            .addSnapshotListener(object : EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if(error!=null){

                    }
                    for(dc: DocumentChange in value?.documentChanges!!){

                        if(dc.type== DocumentChange.Type.ADDED){

                            news_array_lis.add(dc.document.toObject(media_data::class.java))

                        }

                    }

                    news.value=news_array_lis
                    _error.value=error.toString()


                }

            })


    }


}