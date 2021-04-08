package com.irfan.core.pagination

import android.view.View
import android.view.ViewGroup
import com.irfan.core.R
import com.irfan.core.extensions.inflate

/**
 * Custom ViewHolder for showing a Loader.
 */
class PaginationLoadingViewHolder(rootView: View) : PaginationViewHolder(rootView)

fun create(parent: ViewGroup) = PaginationLoadingViewHolder(parent.inflate(R.layout.item_loading))
