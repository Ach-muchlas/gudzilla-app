package com.sss.gudzillaapps.common.device.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sss.gudzillaapps.common.device.domain.usecase.FetchDeviceIdUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchSystemOperationUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchVersionApplicationUseCase
import kotlinx.coroutines.launch

class DeviceViewModel(
    private val getDeviceUseCase: FetchDeviceIdUseCase,
    private val getAppApplication: FetchVersionApplicationUseCase,
    private val systemOperationUseCase: FetchSystemOperationUseCase,
) : ViewModel() {

    private val _deviceId = MutableLiveData<String>()
    val deviceId: LiveData<String> = _deviceId


    init {
        fetchDeviceId()
    }

    private fun fetchDeviceId() {
        viewModelScope.launch {
            try {
                _deviceId.value = getDeviceUseCase()
            } catch (e: Exception) {
                _deviceId.value = "Tidak tersedia"
            }
        }
    }

}