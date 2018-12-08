package com.android.databinding

import android.app.Application
import com.android.databinding.component.DaggerNetComponents
import com.android.databinding.component.NetComponents
import com.android.databinding.module.AppModule
import com.android.databinding.module.NetModule
import com.android.databinding.module.ViewModelModule


class MyApp : Application() {

    companion object {
        lateinit var netComponents: NetComponents

    }

    override fun onCreate() {
        super.onCreate()

        netComponents = DaggerNetComponents.builder()
                .appModule(AppModule(this))
                .netModule(NetModule("https://api.cryptonator.com/api/full/"))
                .viewModelModule(ViewModelModule())
                .build()
    }
}