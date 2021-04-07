package com.irfan.androidtiket

import com.irfan.core.application.CoreApp
import com.irfan.datasource.AppDb
import com.irfan.datasource.util.daoModule
import com.irfan.datasource.util.webServiceModule

class Main : CoreApp() {

    override fun onCreate() {
        super.onCreate()

//        SplitCompat.install(this)
    }

    override fun getDataModules() = arrayOf(
        daoModule(AppDb.getDatabase(applicationContext)),
        webServiceModule
    )
}