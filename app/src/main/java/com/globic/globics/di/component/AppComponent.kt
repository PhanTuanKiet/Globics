package com.globic.globics.di.component

import com.globic.globics.GlobicApplication
import com.globic.globics.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class])
interface AppComponent: AndroidInjector<GlobicApplication> {

    override fun inject(app: GlobicApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: GlobicApplication): Builder

        fun build(): AppComponent
    }

}