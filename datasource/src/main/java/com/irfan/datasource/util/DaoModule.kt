package com.irfan.datasource.util

import com.irfan.datasource.AppDb
import org.koin.dsl.module

fun daoModule(appDb: AppDb) = module {

    single { appDb.UserDao() }

}
