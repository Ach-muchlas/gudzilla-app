package com.sss.gudzillaapps.network.api

import com.sss.gudzillaapps.feature.login.data.response.LoginResponse
import com.sss.gudzillaapps.network.constanta.ApiConstant
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(ApiConstant.LOGIN)
    suspend fun loginUser(
        @Field("username") username : String,
        @Field("password") password : String,
    ) : Response<LoginResponse>
}