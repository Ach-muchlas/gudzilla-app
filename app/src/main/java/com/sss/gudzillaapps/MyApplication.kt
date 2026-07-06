package com.sss.gudzillaapps

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.sss.gudzillaapps.common.manager.SessionManager
import com.sss.gudzillaapps.di.AppModule.dataSource
import com.sss.gudzillaapps.di.AppModule.database
import com.sss.gudzillaapps.di.AppModule.repository
import com.sss.gudzillaapps.di.AppModule.useCase
import com.sss.gudzillaapps.di.AppModule.viewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        SessionManager.getInstance().init(this)

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(database, dataSource, repository, useCase, viewModel))
        }
    }
}