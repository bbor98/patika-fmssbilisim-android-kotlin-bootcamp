package com.borabor.marsrealestate.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.borabor.marsrealestate.data.model.Property
import com.borabor.marsrealestate.databinding.FragmentHomeBinding
import com.borabor.marsrealestate.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // defining adapter with the implementation of item click
        val adapter = PropertyAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToPropertyDetailsFragment(it)
            findNavController().navigate(action)
        }

        binding.rvProperties.adapter = adapter

        binding.btRetry.setOnClickListener {
            viewModel.fetchProperties()
        }

        // collecting StateFlow from ViewModel
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.propertyListResponse.collect { response ->
                    when (response) {
                        is Resource.Success -> {
                            binding.pbLoading.isVisible = false
                            binding.btRetry.isVisible = false

                            adapter.submitList(response.data as List<Property>)
                        }
                        is Resource.Error -> {
                            binding.pbLoading.isVisible = false
                            binding.btRetry.isVisible = true

                            Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                        }
                        Resource.Loading -> {
                            binding.pbLoading.isVisible = true
                            binding.btRetry.isVisible = false
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}