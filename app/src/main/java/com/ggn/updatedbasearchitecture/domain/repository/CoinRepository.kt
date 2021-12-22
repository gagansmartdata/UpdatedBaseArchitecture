package com.ggn.updatedbasearchitecture.domain.repository

import com.ggn.updatedbasearchitecture.common.Resource
import com.ggn.updatedbasearchitecture.data.remote.dto.CoinDto
import com.ggn.updatedbasearchitecture.domain.model.Coin
import com.ggn.updatedbasearchitecture.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    //return of data with Flow is helpful if we have local DB/caching implemented too.Here use cases will have validation and call to this.
    fun getCoins(): Flow<Resource<List<Coin>>>


    //go for normal if no other data source is used (only 1 is there),& Flow emit will move to use cases
    suspend fun getCoinById(coinId: String): CoinDetail
}