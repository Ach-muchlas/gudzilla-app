package com.sss.gudzillaapps.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepository
import com.sss.gudzillaapps.common.device.domain.repository.DeviceRepositoryImpl
import com.sss.gudzillaapps.common.device.domain.usecase.FetchDeviceIdUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchSystemOperationUseCase
import com.sss.gudzillaapps.common.device.domain.usecase.FetchVersionApplicationUseCase
import com.sss.gudzillaapps.common.device.presentation.DeviceViewModel
import com.sss.gudzillaapps.database.AppDatabase
import com.sss.gudzillaapps.database.AppDatabaseManager
import com.sss.gudzillaapps.feature.home.presentation.HomeViewModel
import com.sss.gudzillaapps.feature.purchase_order.data.local.PurchaseOrderLocalDataSource
import com.sss.gudzillaapps.feature.purchase_order.data.local.PurchaseOrderLocalDataSourceImpl
import com.sss.gudzillaapps.feature.purchase_order.domain.repository.PurchaseOrderRepository
import com.sss.gudzillaapps.feature.purchase_order.domain.repository.PurchaseOrderRepositoryImpl
import com.sss.gudzillaapps.feature.purchase_order.domain.usecase.InsertPurchaseOrderUseCase
import com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.CreateInboundViewModel
import com.sss.gudzillaapps.feature.pallet.presentation.PalletViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {

    // database module
    val database = module {
        single {
            Room.databaseBuilder(androidContext(), AppDatabase::class.java, AppDatabase.DB_NAME)
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .fallbackToDestructiveMigration()
                .build().also { AppDatabaseManager.setDatabase(it) }
        }

        single { get<AppDatabase>().purchaserOrderDao() }
    }

    // data source module
    val dataSource = module {
        single<PurchaseOrderLocalDataSource> { PurchaseOrderLocalDataSourceImpl(get()) }
    }

    // repository module
    val repository = module {
        single<DeviceRepository> { DeviceRepositoryImpl(androidContext()) }
        single<PurchaseOrderRepository> { PurchaseOrderRepositoryImpl(get()) }
    }

    // use case module
    val useCase = module {
        single { FetchDeviceIdUseCase(get()) }
        single { FetchSystemOperationUseCase(get()) }
        single { FetchVersionApplicationUseCase(get()) }
        single { InsertPurchaseOrderUseCase(get()) }
    }

    // viewmodel module
    val viewModel = module {
        viewModel { DeviceViewModel(get(), get(), get()) }
        viewModel { HomeViewModel(androidApplication()) }
        viewModel { PalletViewModel(androidApplication()) }
        viewModel { CreateInboundViewModel(get()) }
    }
}