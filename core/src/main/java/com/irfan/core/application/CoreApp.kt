package com.irfan.core.application

import android.app.Application
import com.facebook.stetho.Stetho
import com.irfan.core.BuildConfig
import com.irfan.core.dependencies.androidModule
import com.irfan.core.dependencies.networkModule
import com.irfan.core.dependencies.schedulerModule
import com.irfan.core.dependencies.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class CoreApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initialiseStetho()
        initialiseKoin()
    }

    private fun initialiseStetho() {
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }

    private fun initialiseKoin() {
        startKoin {

            // Logger for Android
            androidLogger()

            // Set the Android Context
            androidContext(this@CoreApp)

            modules(listOf(*defaultModules(), *getDataModules()))
        }
    }

    private fun defaultModules(): Array<Module> =
        arrayOf(androidModule, networkModule, storageModule, schedulerModule)

    /**
     * Return the modules for Data (Dao, WebServices)
     */
    abstract fun getDataModules(): Array<Module>
}