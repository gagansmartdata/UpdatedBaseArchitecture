package com.ggn.updatedbasearchitecture.presentation.feature_one

import androidx.lifecycle.ViewModel
import com.ggn.updatedbasearchitecture.common.Resource
import com.ggn.updatedbasearchitecture.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.ggn.updatedbasearchitecture.domain.model.Coin

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state: StateFlow<CoinListState> = _state

    init {
        getCoins()
    }

    /**
     * fetch coins list using the use cases.
     */
    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    /**
     * interface for coin adapter click callback
     */
    interface RedirectionsFromCoinList{
        fun gotoCoinDetails(coinID : Coin)
    }
}