package com.borabor.marsrealestate.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.borabor.marsrealestate.data.repository.PropertyRepository
import com.borabor.marsrealestate.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PropertyRepository) : ViewModel() {

    private val _propertyListResponse = MutableStateFlow<Resource<Any>>(Resource.Loading)
    val propertyListResponse = _propertyListResponse.asStateFlow()

    init {
        fetchProperties()
    }

    /**
     * Collects data from repository and assigns it to a [MutableStateFlow]
     */
    fun fetchProperties() {
        _propertyListResponse.value = Resource.Loading

        viewModelScope.launch {
            repository.getProperties().collect { response ->
                _propertyListResponse.value = response
            }
        }
    }
}