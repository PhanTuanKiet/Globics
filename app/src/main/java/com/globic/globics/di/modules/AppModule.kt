package com.globic.globics.di.modules

import android.app.Application
import android.content.Context
import com.globic.globics.network.interceptor.NetworkInterceptor
import com.globic.globics.network.monitor.INetworkMonitor
import com.globic.globics.network.monitor.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun bindContext(application: Application): Context

    companion object {
        @Provides
        @Singleton
        open fun provideNetworkInterceptor(application: Application, networkMonitor: INetworkMonitor
        ): NetworkInterceptor {
            return NetworkInterceptor(application.applicationContext, networkMonitor)
        }

        @Provides
        @Singleton
        open fun provideNetworkMonitor(application: Application): INetworkMonitor {
            return NetworkMonitor(application.applicationContext)
        }
    }
}