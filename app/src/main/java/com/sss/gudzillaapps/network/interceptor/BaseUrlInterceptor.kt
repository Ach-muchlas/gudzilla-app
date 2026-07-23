package com.sss.gudzillaapps.network.interceptor

import androidx.core.net.toUri
import com.sss.gudzillaapps.common.manager.ServerManager
import com.sss.gudzillaapps.network.constanta.ServerConstant
import okhttp3.Interceptor
import okhttp3.Response

class BaseUrlInterceptor  : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()
        val newUrlOrigin = ServerManager.getInstance().getServerAddress().trimEnd('/') + "dashboard_api/public/"

        val newUri = newUrlOrigin.toUri()
        val newHttpUrl = originRequest.url.newBuilder()
            .scheme(newUri.scheme ?: "http")
            .host(newUri.host ?: originRequest.url.host)
            .port(newUri.port.takeIf { it !=  -1 } ?: originRequest.url.port)
            .build()

        val newRequest = originRequest.newBuilder().url(newHttpUrl).build()

        return chain.proceed(newRequest)
    }

}