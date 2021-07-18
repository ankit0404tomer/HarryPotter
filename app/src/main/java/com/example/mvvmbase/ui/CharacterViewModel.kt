package com.example.mvvmbase.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmbase.model.CharacterList
import com.example.mvvmbase.network.CharacterApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    var apiService: CharacterApiService
) : ViewModel() {
    private lateinit var subscription: Disposable

    private var characterList = MutableLiveData<CharacterList>()
    val getCharacterList: LiveData<CharacterList>
        get() = characterList

    fun getCharacterList() {
        subscription = apiService.getCharacterList("https://hp-api.herokuapp.com/api/characters")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                subscription = it
            }
            .subscribe(
                { result ->
                    characterList.value = result
                },
                { error ->
                    error.printStackTrace()
                }
            )

    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}
