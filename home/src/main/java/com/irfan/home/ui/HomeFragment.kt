package com.irfan.home.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.view.updatePadding
import androidx.navigation.fragment.FragmentNavigator
import com.irfan.core.ui.BaseFragment
import com.irfan.home.R
import com.irfan.home.di.HomeModule
import com.irfan.home.model.UserUIModel
import com.irfan.home.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import com.irfan.core.domain.Result
import com.irfan.core.extensions.observe
import com.irfan.core.pagination.Pagination
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(R.layout.fragment_home),
    ListUserAdapter.UserListingInteractions {

    override val fragmentTag = TAG

    private val listingViewModel: UserViewModel by viewModel()
    private val moviesListingAdapter = ListUserAdapter(this)
    private lateinit var interactions: UserListingInteractions

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactions = when {
            context is UserListingInteractions -> context
            // Because NavHost is the parent, and DiscoverFragment is it's parent
            parentFragment?.parentFragment is UserListingInteractions -> parentFragment?.parentFragment as UserListingInteractions
            else -> throw IllegalArgumentException("Parent activity or fragment must implement MoviesSectionInteractions")
        }
    }

    override fun loadDependencies() = HomeModule.load()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyStatusBarInsets(view)
        setupAdapter()
        setupListeners()
        fetchData()
    }

    override fun onUserSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras) {
        interactions.onMovieSelected(model, navigatorExtras)
    }

    override fun onNewRequest(request: Pagination.Request) {
        listingViewModel.getMoreMovies("d", 1, 10)
    }

    override fun onReplacedData() {
        recyclerview_user.scheduleLayoutAnimation()
    }

    private fun applyStatusBarInsets(rootView: View) = with(rootView) {
        setOnApplyWindowInsetsListener { _, windowInsets ->
            updatePadding(top = windowInsets.systemWindowInsetTop)
            return@setOnApplyWindowInsetsListener windowInsets
        }
        requestApplyInsets()
    }

    private fun setupAdapter() {
        recyclerview_user.adapter = moviesListingAdapter
    }

    private fun setupListeners() {
        observe(listingViewModel.userData) {
            when (it) {

                is Result.Loading -> {
                    moviesListingAdapter.showLoading()
                }

                is Result.Success -> {
                    moviesListingAdapter.setResult(it.data)
                }

                is Result.Failure -> showError(it.ex)
            }
        }
    }

    private fun fetchData() {
        listingViewModel.getMovies("d", 1, 10)
    }

    private fun showError(ex: Throwable) {
        // TODO
    }

    companion object {
        const val TAG = "MoviesListingFragment"
    }

    interface UserListingInteractions {
        fun onMovieSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras)
    }
}
