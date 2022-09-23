package com.borabor.savestate

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.borabor.savestate.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var text1 = ""
    private var text2 = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater)

        toggleOrientation()

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // saving the first edit text's value
        outState.putString(TEXT_1, binding.editText1.text.toString())
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        savedInstanceState?.let {
            // text1 will not be empty because it was saved
            text1 = it.getString(TEXT_1, "")

            // text2 will be empty because it was not saved
            text2 = it.getString(TEXT_2, "")
        }

        binding.textView1.text = "Text 1: $text1"
        binding.textView2.text = "Text 2: $text2"
    }

    /**
     * Changes orientation according the current orientation.
     *
     */
    private fun toggleOrientation(){
        // toggling orientation
        binding.button.setOnClickListener {
            // getting the current orientation
            val orientation = resources.configuration.orientation

            // setting the orientation according to the current state
            activity?.requestedOrientation = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            } else {
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            }
        }
    }

    // declaring keys as constants
    companion object {
        const val TEXT_1 = "text1"
        const val TEXT_2 = "text2"
    }
}