package com.example.mobiledevlabs.ui.signup

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.data.User
import com.example.mobiledevlabs.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("SignUpFragment", "onCreateView")
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SignUpFragment", "onViewCreated")
        binding.signUpButton.setOnClickListener {
            if (validateInput()) {
                val user = User(binding.emailEditText.text.toString(), binding.usernameEditText.text.toString())
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment(user))
            }
        }
    }

    private fun validateInput(): Boolean {
        val email = binding.emailEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailEditText.error = "Invalid email address"
            return false
        }

        if (username.isEmpty()) {
            binding.usernameEditText.error = "Username is required"
            return false
        }

        if (password.isEmpty() || password.length < 6) {
            binding.passwordEditText.error = "Password must be at least 6 characters"
            return false
        }

        if (password != confirmPassword) {
            binding.confirmPasswordEditText.error = "Passwords do not match"
            return false
        }

        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("SignUpFragment", "onDestroyView")
        _binding = null
    }
}
