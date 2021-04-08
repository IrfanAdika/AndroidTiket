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

    fun getUser(q: String, page: Int) {
        if (_userData.hasValue()) return
        getMoreUser(q, page)
    }

    fun getMoreUser(q: String, page: Int, isSearch: Boolean = false) {
        _userData.setLoading(postValue = true)
        launchOnMain {
            repository.getUser(q, page, 10, isSearch)
                .flowOnBack(dispatcher)
                .collectOn(_userData)
        }
    }

    override fun onCleared() {
        HomeModule.unload()
        super.onCleared()
    }
}