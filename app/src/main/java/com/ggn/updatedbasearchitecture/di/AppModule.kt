package com.ggn.updatedbasearchitecture.di

import android.content.Context
import android.content.SharedPreferences
import com.ggn.updatedbasearchitecture.common.Constants
import com.ggn.updatedbasearchitecture.common.SharedPref.PREF_NAME
import com.ggn.updatedbasearchitecture.data.remote.CoinPaprikaApi
import com.ggn.updatedbasearchitecture.data.repository.CoinRepositoryImpl
import com.ggn.updatedbasearchitecture.data.shared_pref.Preferences
import com.ggn.updatedbasearchitecture.domain.repository.CoinRepository
import com.ggn.updatedbasearchitecture.domain.repository.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePaprikaApi(retrofit: Retrofit): CoinPaprikaApi {
        return retrofit
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceHelper(@ApplicationContext context: Context): PreferencesHelper {
        return Preferences(context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE))
    }
}