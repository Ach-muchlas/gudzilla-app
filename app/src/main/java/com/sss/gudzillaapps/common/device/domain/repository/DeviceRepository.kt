package com.sss.gudzillaapps.common.device.domain.repository

interface DeviceRepository {
    suspend fun fetchDeviceId(): String
    suspend fun fetchVersionApp(): String
    suspend fun fetchSystemOperation(): String
}