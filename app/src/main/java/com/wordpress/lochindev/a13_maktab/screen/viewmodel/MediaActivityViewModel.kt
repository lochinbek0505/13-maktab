package com.wordpress.lochindev.a13_maktab.screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wordpress.lochindev.a13_maktab.firebase.MediaRepository
import com.wordpress.lochindev.a13_maktab.model.media_data

class MediaActivityViewModel:ViewModel() {

    val mediaRepository=MediaRepository()

    private val _error=MutableLiveData<String>()

    val error:LiveData<String> get() {

        return _error

    }

    private val _news=MutableLiveData<ArrayList<media_data>>()

    val news:LiveData<ArrayList<media_data>> get() {

        return _news

    }

    fun getnews(){

        mediaRepository.getNews(_news,_error)

    }

}