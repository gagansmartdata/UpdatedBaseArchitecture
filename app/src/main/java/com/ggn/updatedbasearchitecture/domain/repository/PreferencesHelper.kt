package com.ggn.updatedbasearchitecture.domain.repository

import kotlinx.coroutines.flow.Flow

/** Created by Gagan on 26/10/21.**/
interface PreferencesHelper {
    fun getUserId(): Flow<String>
    suspend fun setUserId(id:String)
}