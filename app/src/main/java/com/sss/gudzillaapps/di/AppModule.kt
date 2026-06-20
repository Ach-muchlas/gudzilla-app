package com.sss.gudzillaapps.di

import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepository
import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepositoryImpl
import com.sss.gudzillaapps.common.device.domain.usecase.FetchDeviceIdUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchSystemOperationUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchVersionApplicationUseCase
import com.sss.gudzillaapps.common.device.presentation.DeviceViewModel
import com.sss.gudzillaapps.feature.home.presentation.HomeViewModel
import com.sss.gudzillaapps.feature.pallet.presentation.PalletViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    // repository module
    val repository = module {
        single<DeviceRepository> { DeviceRepositoryImpl(androidContext()) }
    }

    // use case module
    val useCase = module {
        single { FetchDeviceIdUseCase(get()) }
        single { FetchSystemOperationUseCase(get()) }
        single { FetchVersionApplicationUseCase(get()) }
    }

    // viewmodel module
    val viewModel = module {
        viewModel { DeviceViewModel(    get(), get(), get()) }
        viewModel { HomeViewModel(androidApplication()) }
        viewModel { PalletViewModel(androidApplication()) }
    }
}