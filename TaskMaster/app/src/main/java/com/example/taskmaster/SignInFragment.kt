package com.example.taskmaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.taskmaster.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SignInFragment", "onCreate")

        parentFragmentManager.setFragmentResultListener("signUpRequest", this) { _, bundle ->
            val email = bundle.getString("email")
            binding.emailEditText.setText(email)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        Log.d("SignInFragment", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SignInFragment", "onViewCreated")

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                (activity as? MainActivity)?.navigateToHome()
            } else {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            (activity as? MainActivity)?.navigateToSignUp()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("SignInFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SignInFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SignInFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SignInFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("SignInFragment", "onDestroyView")
    }
}
