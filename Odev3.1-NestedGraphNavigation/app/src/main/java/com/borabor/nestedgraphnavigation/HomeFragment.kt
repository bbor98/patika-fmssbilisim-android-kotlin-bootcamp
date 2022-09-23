package com.borabor.nestedgraphnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.borabor.nestedgraphnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // receiving username argument and adding it to text
        val args = arguments?.let { HomeFragmentArgs.fromBundle(it) }
        args?.let {
            binding.tvWelcome.text = getString(R.string.welcome, it.username)
        }
    }
}