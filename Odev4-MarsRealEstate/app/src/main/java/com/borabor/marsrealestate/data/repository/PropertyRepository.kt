package com.borabor.marsrealestate.data.repository

import com.borabor.marsrealestate.data.model.Property
import com.borabor.marsrealestate.util.Resource
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    /**
     * Executes API request and emits the response.
     *
     * @return list of Mars properties as a [Flow] of [Resource]
     */
    suspend fun getProperties(): Flow<Resource<List<Property>>>
}