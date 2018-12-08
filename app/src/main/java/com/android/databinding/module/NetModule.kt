package com.android.databinding.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.android.databinding.interfaces.CryptocurrencyService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule(var baseUrl: String) {

    //1. Provides SharedPreference
    @Provides
    @Singleton
    fun ProvidesSharedPreference( application: Application):SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    //2. Provides Cache
    @Provides
    @Singleton
    fun ProvidesCache(application:Application):Cache{
        return Cache(application.cacheDir,10*1024*1024L)

    }


    //3. Provides Logging
    @Provides
    @Singleton
    fun ProvidesHttpLoggingInspector():HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    //4. Provides OkHttpClient
    @Provides
    @Singleton
    fun ProvideOkHttpClient(cache:Cache,httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .build()

    }

    //5. Provides Gson
    @Provides
    @Singleton
    fun ProvidesGsonConverter():GsonConverterFactory{
        return GsonConverterFactory.create(Gson())
    }

    //6. Provides Rx2Java Adapter
    @Provides
    @Singleton
    fun ProvidesRx2JavaCallAdapter():RxJava2CallAdapterFactory{
        return RxJava2CallAdapterFactory.create();
    }

    //6. Provides Retrofit
    @Provides
    @Singleton
    fun ProvidesRetrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory,
                         rxJava2CallAdapterFactory: RxJava2CallAdapterFactory):Retrofit{
        return  Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build()
    }

    //7. Provides CryptoService
    @Provides
    @Singleton
    fun ProvidesCryptoService(retrofit: Retrofit):CryptocurrencyService{
        return retrofit.create(CryptocurrencyService::class.java)
    }


}