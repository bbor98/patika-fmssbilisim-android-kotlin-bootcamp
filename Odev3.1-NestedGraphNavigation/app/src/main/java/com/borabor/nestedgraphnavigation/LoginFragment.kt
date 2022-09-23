package com.borabor.nestedgraphnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.borabor.nestedgraphnavigation.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener {
            // assigning EditText inputs to variables
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (checkInputs(username, password)) {
                // defining the global action and passing the username
                val action = LoginFragmentDirections.actionGlobalMainGraph(username)
                // navigating to direction
                findNavController().navigate(action)
            }
        }
    }

    /**
     * Checks if the username and the password are empty, show error if so.
     *
     * @param username username
     * @param password password
     * @return
     * true - if inputs are not empty
     *
     * false - if inputs are empty
     */
    private fun checkInputs(username: String, password: String): Boolean {
        binding.tilUsername.error = if (username.isEmpty()) getString(R.string.empty_username) else null
        binding.tilPassword.error = if (password.isEmpty()) getString(R.string.empty_password) else null

        return username.isNotEmpty() && password.isNotEmpty()
    }
}