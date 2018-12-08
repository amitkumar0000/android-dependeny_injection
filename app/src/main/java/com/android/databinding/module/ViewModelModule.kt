package com.android.databinding.module

import android.arch.lifecycle.MutableLiveData
import com.android.databinding.models.ApiManager
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun ProvidesLiveData():MutableLiveData<String>{
        return MutableLiveData();
    }

    @Provides
    fun ProvidesApiManager():ApiManager{
        return ApiManager()
    }
}