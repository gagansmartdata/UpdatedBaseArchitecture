package com.ggn.updatedbasearchitecture.data.repository

import com.ggn.updatedbasearchitecture.common.Resource
import com.ggn.updatedbasearchitecture.data.remote.CoinPaprikaApi
import com.ggn.updatedbasearchitecture.data.remote.dto.toCoin
import com.ggn.updatedbasearchitecture.data.remote.dto.toCoinDetail
import com.ggn.updatedbasearchitecture.domain.model.Coin
import com.ggn.updatedbasearchitecture.domain.model.CoinDetail
import com.ggn.updatedbasearchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = api.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }

    override fun getCoinById(coinId: String): Flow<Resource<CoinDetail>> =
        flow {
            try {
                emit(Resource.Loading<CoinDetail>())
                val coin = api.getCoinById(coinId).toCoinDetail()
                emit(Resource.Success<CoinDetail>(coin))
            } catch(e: HttpException) {
                emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
            } catch(e: IOException) {
                emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
            }
        }

}