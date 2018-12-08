package com.android.databinding.component

import com.android.databinding.module.AppModule
import com.android.databinding.module.NetModule
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton
import com.android.databinding.MainActivity
import com.android.databinding.models.ApiManager
import com.android.databinding.module.ViewModelModule
import com.android.databinding.ui.NetworkActivity
import com.android.databinding.viewmodels.CryptoViewModel


@Component(modules = arrayOf(AppModule::class, NetModule::class, ViewModelModule::class) )
@Singleton
interface NetComponents {
    fun inject(activity: NetworkActivity)
    fun inject(apiManager: ApiManager)
    fun inject(crypto: CryptoViewModel)
}