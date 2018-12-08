package com.android.databinding

import android.app.Application
import com.android.databinding.component.DaggerNetComponents
import com.android.databinding.component.DaggerViewModelComponent
import com.android.databinding.component.NetComponents
import com.android.databinding.component.ViewModelComponent
import com.android.databinding.module.AppModule
import com.android.databinding.module.NetModule
import com.android.databinding.module.ViewModelModule


class MyApp : Application() {

    companion object {
        lateinit var netComponents: NetComponents
        lateinit var viewmodelComponents: ViewModelComponent

    }

    override fun onCreate() {
        super.onCreate()

       buildComponents()
    }

    fun buildComponents(){
        buildNetComponent()
        buildViewModelComponents()
    }

    private fun buildNetComponent() {
        netComponents = DaggerNetComponents.builder()
                .appModule(AppModule(this))
                .netModule(NetModule("https://api.cryptonator.com/api/full/"))
                .build()
    }

    private fun buildViewModelComponents() {
        viewmodelComponents = DaggerViewModelComponent.builder()
                .viewModelModule(ViewModelModule())
                .build()    }
}