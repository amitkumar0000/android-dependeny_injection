package com.android.databinding.models
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import com.android.databinding.viewmodels.CryptoViewModel
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class CryptoInfo(var cryptD: CryptoViewModel) {
    var cryptoText: ObservableField<String>


    init {
        cryptoText = ObservableField()
        cryptoText.set("Initial Text")
    }

    var count =0
    fun onBtcBtnAction(view: View){
        RxView.clicks(view)
                .debounce(300,TimeUnit.MILLISECONDS,AndroidSchedulers.mainThread())
                .subscribe({
                    count++
                    Log.d("TAG"," getBtc get Called $count")
                    cryptD.getBtcData()
                })
    }


}