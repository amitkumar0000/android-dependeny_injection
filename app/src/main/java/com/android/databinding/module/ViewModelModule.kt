package com.android.databinding.module

import android.arch.lifecycle.MutableLiveData
import com.android.databinding.models.ApiManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun ProvidesLiveData():MutableLiveData<String>{
        return MutableLiveData();
    }

    @Provides
    @Singleton
    fun ProvidesApiManager():ApiManager{
        return ApiManager()
    }
}