package com.irfan.core.dependencies

import android.preference.PreferenceManager
import org.koin.dsl.module

val storageModule = module {

    single { PreferenceManager.getDefaultSharedPreferences(get()) }

}
