package com.wordpress.lochindev.a13_maktab.screen.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wordpress.lochindev.a13_maktab.firebase.HomeRepository
import com.wordpress.lochindev.a13_maktab.model.Statitika_model

class HomeFragmentViewModel:ViewModel() {

    private var _error=MutableLiveData<String>()
    val error:LiveData<String> get(){
        return _error
    }
    var homeRepository=HomeRepository()



    private var _statistika=MutableLiveData<Statitika_model>()
    val statistika:LiveData<Statitika_model> get(){
        return _statistika
    }

    fun getStatistika(){

        homeRepository.getStatistika(_error,_statistika)

    }

}