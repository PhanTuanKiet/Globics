package com.globic.globics.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.globic.globics.network.monitor.INetworkMonitor
import com.globic.globics.network.monitor.NetworkMonitor
import com.globic.globics.utils.Constants
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
        fun provideNetworkMonitor(application: Application): INetworkMonitor {
            return NetworkMonitor(application.applicationContext)
        }

        @Provides
        @Singleton
        fun provideSharePreference(context: Context): SharedPreferences {
            return context.getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE
            )
        }
    }
}