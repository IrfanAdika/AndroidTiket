package com.irfan.datasource.util

import com.irfan.datasource.user.remote.UserWebService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val webServiceModule = module {

    single { get<Retrofit>().create<UserWebService>() }

}
