package com.borabor.marsrealestate.presentation.onboarding

import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borabor.marsrealestate.R
import com.borabor.marsrealestate.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOnboardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvOnboardMessage.text = spannableText()

        binding.btStart.setOnClickListener {
            val action = OnboardingFragmentDirections.actionOnboardingFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

    /**
     * Makes "Solar System" and "Explorer" text yellow.
     *
     * @return modified text
     */
    private fun spannableText() = SpannableStringBuilder(getString(R.string.onboarding_message)).apply {
        setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.yellow)),
            19, 31,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        setSpan(
            ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.yellow)),
            38, 46,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}