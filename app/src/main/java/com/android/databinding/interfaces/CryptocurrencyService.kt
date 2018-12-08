package com.android.databinding.interfaces

import com.android.databinding.models.Crypto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface CryptocurrencyService{


    @GET("{coin}-usd")
    fun getCoinData(@Path("coin") coin: String): Observable<Crypto>
}