package id.co.egifcb.cekhalal.api

import android.content.Context
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import okhttp3.OkHttpClient

class APIConfig {
    companion object {
        fun getConfig(context: Context) {
            val interceptor =  HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder().addInterceptor(interceptor)
                    .build()

            AndroidNetworking.initialize(context, httpClient)
        }
    }
}