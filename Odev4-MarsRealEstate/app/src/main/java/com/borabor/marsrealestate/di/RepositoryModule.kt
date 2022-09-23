package com.borabor.marsrealestate.di

import com.borabor.marsrealestate.data.repository.PropertyRepository
import com.borabor.marsrealestate.data.repository.PropertyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    /**
     * provides [PropertyRepository] with the implementation
     *
     * @param impl implementation of the repository interface
     * @return repository interface
     */
    @Binds
    abstract fun providePropertyRepository(impl: PropertyRepositoryImpl): PropertyRepository
}