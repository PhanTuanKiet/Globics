package com.globic.globics

import android.app.Application
import com.globic.globics.di.component.AppComponent
import com.globic.globics.di.component.DaggerAppComponent
import com.globic.globics.di.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class GlobicApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}