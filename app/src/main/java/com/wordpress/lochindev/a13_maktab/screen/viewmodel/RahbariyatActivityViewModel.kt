package com.wordpress.lochindev.a13_maktab.screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wordpress.lochindev.a13_maktab.firebase.HomeRepository
import com.wordpress.lochindev.a13_maktab.firebase.MediaRepository
import com.wordpress.lochindev.a13_maktab.model.media_data
import com.wordpress.lochindev.a13_maktab.model.rahbariyat_data

class RahbariyatActivityViewModel:ViewModel() {

    val rahbariyatRepository=HomeRepository()

    private val _error=MutableLiveData<String>()

    val error:LiveData<String> get() {

        return _error

    }

    private val _members=MutableLiveData<ArrayList<rahbariyat_data>>()

    val members:LiveData<ArrayList<rahbariyat_data>> get() {

        return _members

    }

    fun getMembers(){

        rahbariyatRepository.getRahbariyat(_error,_members)

    }

}