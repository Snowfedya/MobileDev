package com.example.mobiledevlabs.ui.signup

import android.util.Patterns
import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.data.User
import com.example.mobiledevlabs.databinding.FragmentSignUpBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun setupUI() {
        super.setupUI()
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
}
