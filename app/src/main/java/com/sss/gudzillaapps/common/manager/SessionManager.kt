package com.sss.gudzillaapps.common.manager

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SessionManager private constructor() {
    private lateinit var userPref: SharedPreferences
    private lateinit var appPref: SharedPreferences

    fun init(context: Context) {
        userPref = context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)
        appPref = context.getSharedPreferences(APP_PREF, Context.MODE_PRIVATE)
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





        @Volatile
        private var instance: SessionManager? = null

        fun getInstance(): SessionManager =
            instance ?: synchronized(this) {
                instance ?: SessionManager().also { instance = it }
            }
    }
}