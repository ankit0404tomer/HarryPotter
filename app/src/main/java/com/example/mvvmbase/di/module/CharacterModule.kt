package com.example.mvvmbase.di.module

import com.example.mvvmbase.network.CharacterApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Module which provides all required dependencies about network
 */
@Module
class CharacterModule {


    private val BASE_URL = "https://hp-api.herokuapp.com/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().newBuilder()
    }

    @Provides
     fun provideCharacterApiService(
        retrofitBuilder: Retrofit.Builder): CharacterApiService {

        return retrofitBuilder
            .build()
            .create(CharacterApiService::class.java)
    }

}

// add coil also
