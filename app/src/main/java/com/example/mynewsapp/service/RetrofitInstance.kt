package com.example.mynewsapp.service

import com.example.mynewsapp.Utils.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.Provider

class RetrofitInstance {
    companion object{

        private val retrofit by lazy{

            // to log responses of retrofit

            val logging  = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder().addInterceptor(logging).build()

            Retrofit.Builder().baseUrl(BASE_URL).
            addConverterFactory(GsonConverterFactory.create()).
            client(client).build()

        }

        // we will use this to make api calls
        val api by lazy{

            retrofit.create(Provider.Service::class.java)
        }
    }
}