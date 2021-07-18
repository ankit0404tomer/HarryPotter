package com.example.mvvmbase

import com.example.mvvmbase.di.component.ApplicationComponent
import com.example.mvvmbase.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class Application : DaggerApplication() {
    private lateinit var component: ApplicationComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        component.inject(this)
        return component
    }
}

