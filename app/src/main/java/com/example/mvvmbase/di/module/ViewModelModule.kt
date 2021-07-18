package com.example.mvvmbase.di.module

import androidx.lifecycle.ViewModel
import com.example.mvvmbase.di.scope.ViewModelScoped
import com.example.mvvmbase.ui.CharacterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 *<p>
 * The ViewModelModule is used to provide a mapData of view models through dagger that is used by the ViewModelFactoryModule class.
 *</p>
 */

@Module
 abstract class ViewModelModule : ViewModelFactoryModule(){

    @Binds
    @IntoMap
    @ViewModelScoped(CharacterViewModel::class)
    internal abstract fun appCharacterViewModel(appHomeViewModel: CharacterViewModel): ViewModel

}
