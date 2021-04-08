package com.irfan.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.irfan.core.dispatcher.Dispatcher
import com.irfan.core.extensions.collectOn
import com.irfan.core.extensions.flowOnBack
import com.irfan.core.extensions.hasValue
import com.irfan.core.pagination.Pagination
import com.irfan.core.viewmodel.BaseViewModel
import com.irfan.home.di.HomeModule
import com.irfan.home.domain.UserDomain
import com.irfan.home.model.UserUIModel
import com.irfan.core.extensions.setLoading
import com.irfan.core.domain.Result

class UserViewModel (
    private val repository: UserDomain.Repository,
    private val dispatcher: Dispatcher
) : BaseViewModel(dispatcher) {

    private val _userData = MutableLiveData<Result<Pagination.Result<UserUIModel>>>()

    /** Exposed LiveData **/
    val userData: LiveData<Result<Pagination.Result<UserUIModel>>> = _userData

    fun getMovies(q: String = "", page: Int = 1, perPage: Int = 100) {
        if (_userData.hasValue()) return
        getMoreMovies(q, page, perPage)
    }

    fun getMoreMovies(q: String = "", page: Int = 1, perPage: Int = 100) {
        _userData.setLoading(postValue = true)
        launchOnMain {
            repository.getUser(q, page, perPage)
                .flowOnBack(dispatcher)
                .collectOn(_userData)
        }
    }

    override fun onCleared() {
        HomeModule.unload()
        super.onCleared()
    }
}