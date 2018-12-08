package com.android.databinding.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.android.databinding.MyApp
import com.android.databinding.models.ApiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CryptoViewModel() :ViewModel(){

    @Inject
    lateinit var btcLiveData:MutableLiveData<String>
    @Inject
    lateinit var apiManager:ApiManager

    init{
        MyApp.viewmodelComponents.inject(this)
    }

    fun getBtcData(){
        apiManager.getBtcData()
                .subscribeOn(Schedulers.single())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ x->postBtcData(x) })
    }

    fun postBtcData(data:String){
        btcLiveData.postValue(data)
    }






}