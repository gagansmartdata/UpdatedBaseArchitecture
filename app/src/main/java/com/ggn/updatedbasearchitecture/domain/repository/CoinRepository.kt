package com.ggn.updatedbasearchitecture.domain.repository

import com.ggn.updatedbasearchitecture.common.Resource
import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDto
import com.ggn.updatedbasearchitecture.domain.model.Coin
import com.ggn.updatedbasearchitecture.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    fun getCoins(): Flow<Resource<List<Coin>>>

    fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}