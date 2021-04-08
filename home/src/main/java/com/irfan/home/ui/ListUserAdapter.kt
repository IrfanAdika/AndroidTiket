package com.irfan.home.ui

import android.view.View
import android.view.ViewGroup
import com.irfan.core.extensions.inflate
import com.irfan.core.pagination.BottomPaginationAdapter
import com.irfan.core.pagination.PaginationListener
import com.irfan.core.pagination.PaginationViewHolder
import com.irfan.home.R
import com.irfan.home.model.UserUIModel
import androidx.navigation.fragment.FragmentNavigator
import com.irfan.core.extensions.ScaleType
import com.irfan.core.extensions.defaultImage
import com.irfan.core.extensions.setImage
import kotlinx.android.synthetic.main.item_user.view.*

class ListUserAdapter(private val interactions: UserListingInteractions) :
    BottomPaginationAdapter<UserUIModel>(interactions) {

    override fun onCreateVH(parent: ViewGroup, viewType: Int) = UserViewHolder(
        parent.inflate(R.layout.item_user)
    )

    override fun onBindVH(holder: PaginationViewHolder, position: Int) {
        if (holder is UserViewHolder) holder.bind(dataItems[position], interactions)
    }

    override fun areItemsSame(oldItem: UserUIModel, newItem: UserUIModel) =
        oldItem.id == newItem.id

    class UserViewHolder(rootView: View) : PaginationViewHolder(rootView) {

        fun bind(uiModel: UserUIModel, interactions: UserListingInteractions) = with(itemView) {
            val movieId = uiModel.id
//            val backgroundTransitionName = getBackgroundTransitionName(movieId)
//            val backdropTransitionName = getBackdropImageTransitionName(movieId)

            image_user.apply {
//                transitionName = backdropTransitionName
                setImage(
                    uiModel.avatar ?: "",
                    scaleType = ScaleType.CENTER_CROP,
                    onFailure = { image_user.defaultImage() },
                    fadeIn = false
                )
            }

            label_username.text = uiModel.login

//            clRoot.apply {
//                transitionName = backgroundTransitionName
//                setOnClickListener {
//                    interactions.onMovieSelected(
//                        uiModel, FragmentNavigatorExtras(
//                            ivBackdrop to backdropTransitionName,
//                            clRoot to backgroundTransitionName
//                        )
//                    )
//                }
//            }
        }
    }

    interface UserListingInteractions : PaginationListener {
        fun onUserSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras)
    }
}
