package com.android.databinding.component

import com.android.databinding.module.ViewModelModule
import com.android.databinding.viewmodels.CryptoViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(ViewModelModule::class))
interface ViewModelComponent {
    fun inject(crypto: CryptoViewModel)
}