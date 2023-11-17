package com.example.cleanarckoval220123.app

import android.app.Application
import com.example.cleanarckoval220123.di.appModule
import com.example.cleanarckoval220123.di.dataModule
import com.example.cleanarckoval220123.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(androidContext = applicationContext)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}