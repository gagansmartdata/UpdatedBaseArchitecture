package com.ggn.updatedbasearchitecture.domain.repository

import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDetailDto
import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}