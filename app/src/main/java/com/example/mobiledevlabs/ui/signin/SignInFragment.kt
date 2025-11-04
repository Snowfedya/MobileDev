package com.example.mobiledevlabs.ui.signin

import android.util.Patterns
import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.data.User
import com.example.mobiledevlabs.databinding.FragmentSignInBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    override fun setupUI() {
        super.setupUI()
        binding.signInButton.setOnClickListener {
            if (validateInput()) {
                val user = User(binding.emailEditText.text.toString(), "Username") // Placeholder username
                findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToHomeFragment(user))
            }
        }
        binding.signUpTextView.setOnClickListener {
            findNavController().navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }
    }

    private fun validateInput(): Boolean {
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailEditText.error = "Invalid email address"
            return false
        }

        if (password.isEmpty() || password.length < 6) {
            binding.passwordEditText.error = "Password must be at least 6 characters"
            return false
        }

        return true
    }
}
