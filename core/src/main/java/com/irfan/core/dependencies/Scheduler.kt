package com.irfan.core.dependencies

import com.irfan.core.dispatcher.AppDispatcher
import com.irfan.core.dispatcher.Dispatcher
import org.koin.dsl.module


val schedulerModule = module {

    /** The application-level dispatcher for scheduling work on threads **/
    /** The application-level dispatcher for scheduling work on threads **/
    single<Dispatcher> { AppDispatcher() }

}
