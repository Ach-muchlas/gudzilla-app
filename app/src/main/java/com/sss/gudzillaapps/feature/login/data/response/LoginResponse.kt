package com.sss.gudzillaapps.feature.login.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("data")
	val data: DataItemUserLogin? = null,

    @field:SerializedName("error_code")
	val errorCode: Int? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Boolean? = null,

    @field:SerializedName("token")
	val token: String? = null
)

data class DataItemUserLogin(

	@field:SerializedName("site_name")
	val siteName: String? = null,

	@field:SerializedName("orlan_username")
	val orlanUsername: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("site_id")
	val siteId: String? = null,

	@field:SerializedName("user_group_name")
	val userGroupName: String? = null,

	@field:SerializedName("user_group_id")
	val userGroupId: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)


data class SessionUser(
    val employeeName : String?,
    val username : String?,
    val siteId : String?,
    val siteName : String?,
    val division : String?,
    val token : String?
)