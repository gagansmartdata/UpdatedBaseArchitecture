package com.ggn.updatedbasearchitecture.domain.use_case.get_coin

import com.ggn.updatedbasearchitecture.common.Resource
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

class GetCoinById @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = 
    flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId)
            emit(Resource.Success<CoinDetail>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}