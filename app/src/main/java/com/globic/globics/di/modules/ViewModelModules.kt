package com.globic.globics.di.modules

import androidx.lifecycle.ViewModelProvider
import com.globic.globics.mvvm.viewModels.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModules {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

//    @Binds
//    @IntoMap
//    @ViewModelKey(LoginViewModel::class)
//    abstract fun movieListViewModel(moviesListViewModel: LoginViewModel): ViewModel

}