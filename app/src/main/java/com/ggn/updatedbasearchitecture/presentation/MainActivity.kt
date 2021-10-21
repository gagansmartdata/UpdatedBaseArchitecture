package com.ggn.updatedbasearchitecture.presentation

import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.BaseActivity
import com.ggn.updatedbasearchitecture.databinding.ActivityMainBinding
import com.ggn.updatedbasearchitecture.presentation.feature_one.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main
    override var binding: ActivityMainBinding
        get() = setUpBinding()
        set(value) {}

    //using feature1 view model with main activity for demo purpose
    private val viewModel:CoinListViewModel by viewModels()

    override fun bindData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                if (it.coins.isNotEmpty()) {
                    binding.data.text= it.coins.first().name
                }
            }
        }
    }

    override fun initListeners() {

    }
}