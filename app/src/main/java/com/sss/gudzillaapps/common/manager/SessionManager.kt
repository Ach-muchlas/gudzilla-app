package com.sss.gudzillaapps.common.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.sss.gudzillaapps.feature.login.data.response.SessionUser

class SessionManager private constructor() {
    private lateinit var userPref: SharedPreferences
    private lateinit var appPref: SharedPreferences

    fun init(context: Context) {
        userPref = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
        appPref = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
    }

    fun saveDataUser(data: SessionUser) {
        userPref.edit().apply {
            putString(KEY_USERNAME, data.username)
            putString(KEY_EMPLOYEE_NAME, data.employeeName)
            putString(KEY_DIVISION, data.division)
            putString(KEY_SITE_ID, data.siteId)
            putString(KEY_SITE_NAME, data.siteName)
            putString(KEY_TOKEN, data.token)
        }
    }


    fun getDataUser(): SessionUser {
        return SessionUser(
            username = userPref.getString(KEY_USERNAME, null),
            employeeName = userPref.getString(KEY_EMPLOYEE_NAME, null),
            division = userPref.getString(KEY_DIVISION, null),
            siteId = userPref.getString(KEY_SITE_ID, null),
            siteName = userPref.getString(KEY_SITE_NAME, null),
            token = userPref.getString(KEY_TOKEN, null)
        )
    }

    fun isUserLogin(): Boolean =
        userPref.getBoolean(KEY_LOGIN, false)

    fun clearSession() {
        userPref.edit { clear() }
    }


    fun isFirstTime(): Boolean =
        appPref.getBoolean(KEY_IS_FIRST_TIME, true)

    fun setFirstTimeFalse() {
        appPref.edit { putBoolean(KEY_IS_FIRST_TIME, false) }
    }


    companion object {
        private const val USER_PREF = "user_pref"
        private const val APP_PREF = "app_pref"
        private const val KEY_IS_FIRST_TIME = "is_first_time"
        private const val KEY_LOGIN = "is_login"

        private const val KEY_EMPLOYEE_NAME = "name"
        private const val KEY_USERNAME = "username"
        private const val KEY_DIVISION = "user_group_name"
        private const val KEY_SITE_ID = "site_id"
        private const val KEY_SITE_NAME = "site_name"
        private const val KEY_TOKEN = "token"

        @Volatile
        private var instance: SessionManager? = null

        fun getInstance(): SessionManager =
            instance ?: synchronized(this) {
                instance ?: SessionManager().also { instance = it }
            }
    }
}