package com.example.mobiledevlabs.ui.signin

import android.os.Bundle
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mobiledevlabs.data.User
import com.example.mobiledevlabs.databinding.FragmentSignInBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    // --- Safe Args: Receiving data in SignIn ---
    private val args: SignInFragmentArgs by navArgs()

    override fun setupUI() {
        super.setupUI()

        // Pre-fill email from SignUpFragment, if available
        args.user?.let {
            binding.emailEditText.setText(it.email)
        }

        binding.signInButton.setOnClickListener {
            if (validateInput()) {
                val email = binding.emailEditText.text.toString()

                // Note: This is a simplified login. In a real app, you would verify the password.
                val loggedInUser = args.user ?: User.getSampleUsers().first { it.email == email }

                // --- Safe Args: Sending data from SignIn to Home ---
                val action = SignInFragmentDirections.actionSignInFragmentToHomeFragment(loggedInUser)
                findNavController().navigate(action)
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
            binding.emailInputLayout.error = "Invalid email address"
            return false
        } else {
            binding.emailInputLayout.error = null
        }

        if (password.isEmpty()) {
            binding.passwordInputLayout.error = "Password cannot be empty"
            return false
        } else {
            binding.passwordInputLayout.error = null
        }

        return true
    }
}
