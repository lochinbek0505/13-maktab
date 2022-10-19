package com.wordpress.lochindev.a13_maktab.firebase

import android.util.Log
import com.google.firebase.firestore.*
import com.wordpress.lochindev.a13_maktab.screen.fragment.HomeFragment
import com.wordpress.lochindev.a13_maktab.model.Statitika_model

class Firestore {


    private val mFirestore = FirebaseFirestore.getInstance()
    private lateinit var   statistika:Statitika_model
    fun getStatistika(){

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
                    statistika = documentSnapshot.toObject(Statitika_model::class.java)!!
                }
            }.addOnFailureListener {
                    e -> Log.e("TAG", "Error writing document", e)
            }

        HomeFragment().setText(statistika)


    }

//    fun getStatistika(): Statitika_model {
//        var statistika:Statitika_model?
//        mFirestore.collection("Statistika").orderBy("boys", Query.Direction.ASCENDING)
//            .addSnapshotListener(object : EventListener<QuerySnapshot> {
//                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
//                    if (error != null) {
//
//                    }
//                    for (dc: DocumentChange in value?.documentChanges!!) {
//
//                        if (dc.type == DocumentChange.Type.ADDED) {
//
//                            statistika = dc.document.toObject(Statitika_model::class.java)
//
//                        }
//
//
//                    }
//
//                }
//
//            })
//
//        return statistika!!
//
//    }
}
