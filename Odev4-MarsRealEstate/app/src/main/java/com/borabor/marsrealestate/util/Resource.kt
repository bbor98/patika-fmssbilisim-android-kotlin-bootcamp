package com.borabor.marsrealestate.util

/**
 *
 * An utility class to define UI state
 *
 * @param T any kind of data
 */
sealed class Resource<out T> {
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String?) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}