package com.ggn.updatedbasearchitecture.presentation.feature_one

import com.ggn.updatedbasearchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
