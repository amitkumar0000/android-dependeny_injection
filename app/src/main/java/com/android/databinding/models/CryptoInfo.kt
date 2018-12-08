package com.android.databinding.models

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.ObservableField
import android.view.View
import com.android.databinding.ui.NetworkActivity
import com.android.databinding.viewmodels.CryptoViewModel

class CryptoInfo(var cryptD: CryptoViewModel) {
    var cryptoText: ObservableField<String>


    init {
        cryptoText = ObservableField()
        cryptoText.set("Initial Text")
    }


    fun onBtcBtnAction(view: View){
        cryptD.getBtcData()
    }


}