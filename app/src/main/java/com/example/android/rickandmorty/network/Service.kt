package com.example.android.rickandmorty.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/"

// Use the Moshi Builder to create a Moshi object with the KotlinJsonAdapterFactory
private val moshi= Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Use Retrofit Builder with ScalarsConverterFactory and BaseURL
var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()

interface Service {
    @GET("character")
    fun getCharactersAsync():
            Deferred<NetworkCharacterContainer>
}

object Api {
    val retrofitService: Service by lazy {
        retrofit.create(Service::class.java)
    }
}
