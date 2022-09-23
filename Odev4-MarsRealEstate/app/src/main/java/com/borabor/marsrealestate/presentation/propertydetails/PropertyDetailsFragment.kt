package com.borabor.marsrealestate.presentation.propertydetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borabor.marsrealestate.databinding.FragmentPropertyDetailsBinding

class PropertyDetailsFragment : Fragment() {

    private var _binding: FragmentPropertyDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentPropertyDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // getting the property data from args and assigning it to the binding.property variable
        val args = arguments?.let { PropertyDetailsFragmentArgs.fromBundle(it) }
        args?.let { binding.property = it.property }

        // navigating back
        binding.btBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // opening "google.com.tr" in browser
        binding.btBuy.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.tr")))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}