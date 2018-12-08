package com.android.databinding.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.databinding.R
import com.android.databinding.models.CryptoInfo
import javax.inject.Inject
import com.android.databinding.viewmodels.CryptoViewModel


class NetworkActivity  : AppCompatActivity() {

    lateinit var cryptData:CryptoViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var networkActBinding:NetworkActBinding = DataBindingUtil.setContentView(this,R.layout.activity_network)

        cryptData = ViewModelProviders.of(this).get(CryptoViewModel::class.java)

        var cryptoInfo = CryptoInfo(cryptData)
        networkActBinding.cryptoInfo = cryptoInfo

        cryptData.btcLiveData
                .observe(this, Observer<String> { x->
                    cryptoInfo.cryptoText.set(x)
                })

    }


}
