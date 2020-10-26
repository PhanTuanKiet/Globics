package com.globic.globics.network.interceptor

import android.content.Context
import com.globic.globics.network.monitor.INetworkMonitor
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkInterceptor(context: Context, networkMonitor: INetworkMonitor) : Interceptor {
    private val networkMonitor: INetworkMonitor = networkMonitor
    private val context: Context = context

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (networkMonitor.isConnected()) {
            chain.proceed(chain.request())
        } else {
            throw RuntimeException()
        }
    }

}