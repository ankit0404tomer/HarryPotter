package com.example.mvvmbase.di.component

import com.example.mvvmbase.Application
import com.example.mvvmbase.di.module.ActivityBindingModule
import com.example.mvvmbase.di.module.CharacterModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    CharacterModule::class])
interface ApplicationComponent : AndroidInjector<Application> {

    override fun inject(instance: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}
