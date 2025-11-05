package com.example.restaurantapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.R
import com.example.restaurantapp.base.BaseFragment
import com.example.restaurantapp.databinding.FragmentSignInBinding
import com.example.restaurantapp.model.User

class SignInFragment : BaseFragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    // Фиктивные данные для входа
    private val validEmail = "test@example.com"
    private val validPassword = "123456"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        handleRegistrationResult()
    }

    private fun setupClickListeners() {
        binding.btnSignIn.setOnClickListener {
            performSignIn()
        }

        binding.btnGoToSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
    }

    private fun performSignIn() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (validateInput(email, password)) {
            // Передаем email в HomeFragment
            val action = SignInFragmentDirections.actionSignInFragmentToHomeFragment(email)
            findNavController().navigate(action)
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                showError("Пожалуйста, введите email")
                false
            }
            password.isEmpty() -> {
                showError("Пожалуйста, введите пароль")
                false
            }
            email == validEmail && password == validPassword -> {
                true
            }
            email.contains("@") && password.length >= 6 -> {
                // Принимаем любой корректно оформленный email и пароль длиной 6+ символов
                true
            }
            else -> {
                showError("Неверный email или пароль")
                false
            }
        }
    }

    private fun handleRegistrationResult() {
        // Получаем данные из SignUpFragment если пользователь вернулся после регистрации
        val currentBackStackEntry = findNavController().currentBackStackEntry
        currentBackStackEntry?.savedStateHandle?.getLiveData<User>("registered_user")?.observe(viewLifecycleOwner) { user ->
            if (user != null) {
                // Заполняем поля данными зарегистрированного пользователя
                binding.etEmail.setText(user.email)
                binding.tvUserInfo.text = "Добро пожаловать, ${user.name}!\nEmail: ${user.email}"
                binding.tvUserInfo.visibility = View.VISIBLE
                
                // Очищаем данные после использования
                currentBackStackEntry.savedStateHandle.remove<User>("registered_user")
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}