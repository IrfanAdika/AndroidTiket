package com.irfan.home.ui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.view.updatePadding
import androidx.navigation.fragment.FragmentNavigator
import com.irfan.core.domain.Result
import com.irfan.core.extensions.observe
import com.irfan.core.pagination.Pagination
import com.irfan.core.ui.BaseFragment
import com.irfan.home.R
import com.irfan.home.di.HomeModule
import com.irfan.home.model.UserUIModel
import com.irfan.home.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment(R.layout.fragment_home),
    ListUserAdapter.UserListingInteractions {

    override val fragmentTag = TAG

    private var searchQuery = "a"
    private var page = 1
    private val listingViewModel: UserViewModel by viewModel()
    private val moviesListingAdapter = ListUserAdapter(this)
    private lateinit var interactions: UserListingInteractions

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interactions = when {
            context is UserListingInteractions -> context
            // Because NavHost is the parent, and DiscoverFragment is it's parent
            parentFragment?.parentFragment is UserListingInteractions -> parentFragment?.parentFragment as UserListingInteractions
            else -> throw IllegalArgumentException("Parent activity or fragment must implement UserListingInteractions")
        }
    }

    override fun loadDependencies() = HomeModule.load()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        applyStatusBarInsets(view)
        setupAdapter()
        setupSearch()
        setupListeners()
        fetchData()
    }

    override fun onUserSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras) {
        interactions.onUserSelected(model, navigatorExtras)
    }

    override fun onNewRequest(request: Pagination.Request) {
        listingViewModel.getMoreUser(searchQuery, page)
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
                    showData()
                    moviesListingAdapter.setResult(it.data)

                }

                is Result.Failure -> showError(it.ex)
            }
        }
    }

    private fun showData() {
        page ++
        Log.i("total_page", page.toString())
    }

    private fun setupSearch() {
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String?) = true

            override fun onQueryTextSubmit(query: String?): Boolean {
                page = 1
                return query?.let { listingViewModel.getMoreUser(it, page, true); true } ?: false
            }
        })
    }

    private fun fetchData() {
        listingViewModel.getUser(searchQuery, page)
    }

    private fun showError(ex: Throwable) {
        val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(
            requireActivity()
        )
        alertDialogBuilder.setTitle("Oops")
        alertDialogBuilder
            .setMessage("Data Not Found")
            .setIcon(R.drawable.icon_placeholder)
            .setCancelable(false)
            .setNegativeButton(
                "Tidak",
                DialogInterface.OnClickListener { dialog, id ->
                    dialog.cancel()
                })

        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    companion object {
        const val TAG = "HomeFragment"
    }

    interface UserListingInteractions {
        fun onUserSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras)
    }
}
