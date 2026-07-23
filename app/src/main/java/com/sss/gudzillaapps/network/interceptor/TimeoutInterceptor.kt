package com.sss.gudzillaapps.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class TimeoutInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestMethodGet = request.method == "GET"

        return chain
            .withConnectTimeout(15, TimeUnit.SECONDS)
            .withReadTimeout(if (requestMethodGet) 30 else 60, TimeUnit.SECONDS)
            .withWriteTimeout(if (requestMethodGet) 30 else 60, TimeUnit.SECONDS)
            .proceed(request = request)
    }
}