package com.example.mvvmbase.network

import com.example.mvvmbase.model.CharacterList

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Url


interface CharacterApiService {

    @GET
    fun getCharacterList(@Url characterList: String): Single<CharacterList>
}
