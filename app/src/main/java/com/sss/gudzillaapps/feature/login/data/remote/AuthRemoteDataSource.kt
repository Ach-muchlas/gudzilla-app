package com.sss.gudzillaapps.feature.login.data.remote

import com.sss.gudzillaapps.feature.login.data.response.LoginResponse

interface AuthRemoteDataSource {
    suspend fun userLogin() : LoginResponse
}