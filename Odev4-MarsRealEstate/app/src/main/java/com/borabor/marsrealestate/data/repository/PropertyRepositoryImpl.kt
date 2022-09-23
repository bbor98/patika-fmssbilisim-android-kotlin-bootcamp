package com.borabor.marsrealestate.data.repository

import com.borabor.marsrealestate.data.api.MarsApi
import com.borabor.marsrealestate.data.model.Property
import com.borabor.marsrealestate.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PropertyRepositoryImpl @Inject constructor(private val api: MarsApi) : PropertyRepository {
    override suspend fun getProperties(): Flow<Resource<List<Property>>> = flow {
        emit(
            try {
                val result = api.getProperties()
                Resource.Success(result)
            } catch (e: Exception) {
                Resource.Error(e.message)
            }
        )
    }
}