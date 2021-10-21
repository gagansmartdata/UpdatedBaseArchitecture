package com.ggn.updatedbasearchitecture.presentation.feature_two

import com.ggn.updatedbasearchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
