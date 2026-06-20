package com.sss.gudzillaapps.common.device.domain.repository

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings

class DeviceRepositoryImpl(private val context: Context) : DeviceRepository {

    @SuppressLint("HardwareIds")
    override suspend fun fetchDeviceId(): String {
        return Settings.Secure.getString(
            context.contentResolver,
            Settings.Secure.ANDROID_ID
        ) ?: "-"
    }

    override suspend fun fetchVersionApp(): String {
        val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)
        return "${packageInfo.versionName}"
    }

    override suspend fun fetchSystemOperation(): String {
        return "Android ${Build.VERSION.RELEASE} (${Build.VERSION.SDK_INT})"
    }

}