package com.ggn.updatedbasearchitecture.presentation.feature_one

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.BaseActivity
import com.ggn.updatedbasearchitecture.databinding.ActivityCoinListBinding
import com.ggn.updatedbasearchitecture.domain.model.Coin
import com.ggn.updatedbasearchitecture.presentation.feature_two.CoinDetailsActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class CoinListActivity : BaseActivity<ActivityCoinListBinding>(),
    CoinListAdapter.RedirectionsFromCoinList {

    override val layoutId: Int
        get() = R.layout.activity_coin_list
    override var binding: ActivityCoinListBinding
        get() = setUpBinding()
        set(value) {}

    //using lazy loading to load the view model instance
    private val viewModel:CoinListViewModel by viewModels()

    override fun bindData() {
        lifecycleScope.launchWhenStarted {
            viewModel.state().collect {
              binding.state = it
                it.data?.let {list->
                    if (list.isNotEmpty()) {
                        showCoinList(list.take(10))
                    }
                }
            }
        }
    }

    override fun initListeners() {

    }

    private fun showCoinList(dataList : List<Coin>){
        binding.recyclerView.adapter = CoinListAdapter(dataList,this)
    }

    override fun gotoCoinDetails(coinID: Coin) {
        CoinDetailsActivity.start(this, coinID.id)
    }

    companion object{
        fun start(context: Context){
            context.startActivity(Intent(context, CoinListActivity::class.java))
        }
    }
}