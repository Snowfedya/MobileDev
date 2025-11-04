package com.example.mobiledevlabs.ui.signup

import android.util.Patterns
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.R
import com.example.mobiledevlabs.data.User
import com.example.mobiledevlabs.databinding.FragmentSignUpBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun setupUI() {
        super.setupUI()

        // Setup Spinners
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.genders,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.genderSpinner.adapter = adapter
        }

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.ages,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.ageSpinner.adapter = adapter
        }

        binding.createAccountButton.setOnClickListener {
            if (validateInput()) {
                val user = User(
                    email = binding.emailEditText.text.toString(),
                    username = binding.nameEditText.text.toString()
                )
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToHomeFragment(user))
            }
        }
    }

    private fun validateInput(): Boolean {
        val email = binding.emailEditText.text.toString()
        val username = binding.nameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()

        if (username.isEmpty()) {
            binding.nameInputLayout.error = "Name is required"
            return false
        } else {
            binding.nameInputLayout.error = null
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.emailInputLayout.error = "Invalid email address"
            return false
        } else {
            binding.emailInputLayout.error = null
        }

        if (password.isEmpty() || password.length < 6) {
            binding.passwordInputLayout.error = "Password must be at least 6 characters"
            return false
        } else {
            binding.passwordInputLayout.error = null
        }

        if (password != confirmPassword) {
            binding.confirmPasswordInputLayout.error = "Passwords do not match"
            return false
        } else {
            binding.confirmPasswordInputLayout.error = null
        }

        if (!binding.termsCheckbox.isChecked) {
            binding.termsCheckbox.error = "You must accept the terms and conditions"
            return false
        } else {
            binding.termsCheckbox.error = null
        }

        if (!binding.privacyCheckbox.isChecked) {
            binding.privacyCheckbox.error = "You must accept the privacy policy"
            return false
        } else {
            binding.privacyCheckbox.error = null
        }

        return true
    }
}
