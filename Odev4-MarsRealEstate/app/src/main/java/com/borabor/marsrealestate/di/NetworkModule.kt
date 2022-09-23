package com.borabor.marsrealestate.di

import com.borabor.marsrealestate.data.api.MarsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://mars.udacity.com/"

    /**
     * Provides [Retrofit] instance
     *
     * @return Singleton [Retrofit] instance
     */
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /**
     * Provides [MarsApi]
     *
     * @param retrofit Retrofit instance
     * @return Singleton [MarsApi] instance
     */
    @Singleton
    @Provides
    fun provideMarsApi(retrofit: Retrofit): MarsApi = retrofit.create(MarsApi::class.java)
}