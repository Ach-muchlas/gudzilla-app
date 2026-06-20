package com.sss.gudzillaapps.common.device.domain.usecase

import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepository

class FetchVersionApplicationUseCase(private val deviceRepository: DeviceRepository) {
    suspend operator fun invoke(): String = deviceRepository.fetchVersionApp()
}