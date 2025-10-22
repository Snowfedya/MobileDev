package com.example.mobiledev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.textfield.TextInputEditText

class SignInFragment : Fragment() {

    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("signUpRequestKey") { key, bundle ->
            val user = bundle.getParcelable<User>("user")
            user?.let {
                emailEditText.setText(it.email)
                passwordEditText.setText(it.password)
                Toast.makeText(requireContext(), "Registration successful!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        val signInButton = view.findViewById<Button>(R.id.signInButton)
        val signUpButton = view.findViewById<Button>(R.id.signUpButton)

        signInButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(requireContext(), "Sign in successful", Toast.LENGTH_SHORT).show()
                (activity as MainActivity).navigateToHome()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            (activity as MainActivity).navigateToSignUp()
        }

        return view
    }
}
