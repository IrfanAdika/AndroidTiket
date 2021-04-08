package com.irfan.androidtiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.FragmentNavigator
import com.irfan.core.ui.BaseActivity
import com.irfan.home.model.UserUIModel
import com.irfan.home.ui.HomeFragment

class MainActivity : BaseActivity(R.layout.activity_main), HomeFragment.UserListingInteractions {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onMovieSelected(model: UserUIModel, navigatorExtras: FragmentNavigator.Extras) {

    }
}