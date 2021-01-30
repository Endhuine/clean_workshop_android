package com.endhuine.data.injection

import com.endhuine.data.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Module declaration for providing Apis
 */
@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun userApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}