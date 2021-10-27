package com.ggn.updatedbasearchitecture.presentation.feature_two

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.BaseActivity
import com.ggn.updatedbasearchitecture.common.Constants
import com.ggn.updatedbasearchitecture.databinding.ActivityCoinDetailsBinding
import com.ggn.updatedbasearchitecture.databinding.ActivityCoinListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CoinDetailsActivity : BaseActivity<ActivityCoinDetailsBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_coin_details
    override var binding: ActivityCoinDetailsBinding
        get() = setUpBinding()
        set(value) {}

    private val viewModel:CoinDetailViewModel by viewModels()

    override fun bindData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect {
                binding.state = it
            }
        }
    }

    override fun initListeners() {

    }


    companion object{
        fun start(context: Context,coinId :String){
            context.startActivity(Intent(context, CoinDetailsActivity::class.java).apply {
                putExtra(Constants.PARAM_COIN_ID,coinId)
            })
        }
    }
}