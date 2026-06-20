package com.sss.gudzillaapps.common.device.domain.usecase

import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepository

class FetchSystemOperationUseCase(private val deviceRepository: DeviceRepository) {
    suspend operator fun invoke(): String = deviceRepository.fetchDeviceId()
}