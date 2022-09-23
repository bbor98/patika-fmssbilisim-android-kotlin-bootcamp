package com.borabor.marsrealestate.data.api

import com.borabor.marsrealestate.data.model.Property
import retrofit2.http.GET

interface MarsApi {
    /**
     * GET request for Mars property list
     *
     * @return list of Mars properties
     */
    @GET("realestate")
    suspend fun getProperties(): List<Property>
}