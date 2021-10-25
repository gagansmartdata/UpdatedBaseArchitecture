package com.ggn.updatedbasearchitecture.presentation.feature_one

import com.ggn.updatedbasearchitecture.R
import com.ggn.updatedbasearchitecture.base.InfiniteAdapter
import com.ggn.updatedbasearchitecture.databinding.InflatorCoinListBinding
import com.ggn.updatedbasearchitecture.domain.model.Coin

/** Created by Gagan on 25/10/21.**/
class CoinListAdapter(val list : List<Coin>,val coinClick: CoinListViewModel.RedirectionsFromCoinList) : InfiniteAdapter<InflatorCoinListBinding>() {

    init {
        setShouldLoadMore(false)
    }

    override fun bindData(position: Int, myViewHolderG: MyViewHolderG?) {
        myViewHolderG?.apply {
            binding.data= list[position]
            binding.onClick= coinClick
            binding.executePendingBindings()
        }
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getInflateLayout(type: Int): Int {
        return R.layout.inflator_coin_list
    }
}