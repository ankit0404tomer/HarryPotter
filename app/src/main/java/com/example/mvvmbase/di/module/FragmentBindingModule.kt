package com.example.mvvmbase.di.module

import com.example.mvvmbase.di.scope.FragmentScoped
import com.example.mvvmbase.ui.CharacterFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideCharacterFragment(): CharacterFragment
}
