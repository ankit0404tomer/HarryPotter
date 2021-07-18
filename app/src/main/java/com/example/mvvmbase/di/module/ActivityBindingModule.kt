package com.example.mvvmbase.di.module

import com.example.mvvmbase.MainActivity
import com.example.mvvmbase.di.scope.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module(
    includes = [ViewModelModule::class]
)

abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [FragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}
