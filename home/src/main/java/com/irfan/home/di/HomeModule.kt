package com.irfan.home.di

import com.irfan.core.dependencies.base.BaseModule
import com.irfan.home.domain.UserDomain
import com.irfan.home.domain.UserRemote
import com.irfan.home.domain.UserRepository
import com.irfan.home.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

/**
 * Dependency injection for Discover Movies
 */
object HomeModule : BaseModule {

    override fun load() {
        // TODO(calvinnor): This is a hack to prevent re-initialisation of Koin modules when
        // a new Fragment is init. Find a way to check if these already exist
        unloadKoinModules(sectionMoviesModule)
        loadKoinModules(sectionMoviesModule)
    }

    override fun unload() = unloadKoinModules(sectionMoviesModule)
}

private val sectionMoviesModule = module {

    factory<UserDomain.Remote> { UserRemote(userWebService = get()) }

    factory<UserDomain.Repository> { UserRepository(remote = get()) }

    viewModel { UserViewModel(dispatcher = get(), repository = get()) }

}