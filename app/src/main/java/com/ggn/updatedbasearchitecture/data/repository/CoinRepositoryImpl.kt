package com.ggn.updatedbasearchitecture.data.repository

import com.ggn.updatedbasearchitecture.data.remote.CoinPaprikaApi
import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDetailDto
import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDto
import com.ggn.updatedbasearchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}