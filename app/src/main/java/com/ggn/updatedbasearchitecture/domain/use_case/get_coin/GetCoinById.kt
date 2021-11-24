package com.ggn.updatedbasearchitecture.domain.use_case.get_coin

import com.ggn.updatedbasearchitecture.common.Resource
import com.ggn.updatedbasearchitecture.domain.model.CoinDetail
import com.ggn.updatedbasearchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinById @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>>
    {
        if (coinId.isBlank()) {
            return flow {
                emit(Resource.Error<CoinDetail>("Missing coin ID."))
            }
        }
        return repository.getCoinById(coinId)
    }
}