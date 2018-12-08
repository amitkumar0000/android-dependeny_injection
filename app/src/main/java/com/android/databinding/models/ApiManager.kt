package com.android.databinding.models

import android.app.Application
import com.android.databinding.MyApp
import com.android.databinding.interfaces.CryptocurrencyService
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.util.concurrent.Callable
import javax.inject.Inject


class ApiManager {
    @Inject
    public lateinit var cryptocurrencyService: CryptocurrencyService

    init {
        MyApp.netComponents.inject(this)
    }

    fun getBtcData(): Observable<String> {

        return cryptocurrencyService.getCoinData("btc")
                .map { x->x.ticker?.base +" return from Rxjava" }

    }


}