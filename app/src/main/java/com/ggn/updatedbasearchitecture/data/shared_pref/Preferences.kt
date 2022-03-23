package com.ggn.updatedbasearchitecture.data.shared_pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ggn.updatedbasearchitecture.domain.repository.PreferencesHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Preferences @Inject constructor(private val prefData: DataStore<Preferences>) : PreferencesHelper {

    private object PreferencesKeys {
        val USER_ID = stringPreferencesKey("user_name")
        //val SHOW_COMPLETED = booleanPreferencesKey("show_completed")
    }

    override fun getUserId(): Flow<String> {
        return prefData.data.map {prefrencee->
            prefrencee[PreferencesKeys.USER_ID] ?: "id"
        }
    }

    override suspend fun setUserId(id:String) {
        prefData.edit { preferences ->
            preferences[PreferencesKeys.USER_ID] = id
        }
    }
}
