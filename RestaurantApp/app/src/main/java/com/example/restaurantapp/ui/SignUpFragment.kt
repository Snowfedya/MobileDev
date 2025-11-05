package com.example.restaurantapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.restaurantapp.base.BaseFragment
import com.example.restaurantapp.databinding.FragmentSignUpBinding
import com.example.restaurantapp.model.User

class SignUpFragment : BaseFragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSignUp.setOnClickListener {
            performSignUp()
        }

        binding.btnBackToSignIn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun performSignUp() {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val confirmPassword = binding.etConfirmPassword.text.toString().trim()
        val age = binding.etAge.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val gender = when (binding.rgGender.checkedRadioButtonId) {
            binding.rbMale.id -> "Мужской"
            binding.rbFemale.id -> "Женский"
            else -> ""
        }

        if (validateInput(name, email, password, confirmPassword, age, phone, gender)) {
            val user = User(
                name = name,
                email = email,
                password = password,
                age = age.toIntOrNull() ?: 0,
                gender = gender,
                phone = phone
            )

            // Передаем данные пользователя обратно в SignInFragment
            val previousBackStackEntry = findNavController().previousBackStackEntry
            previousBackStackEntry?.savedStateHandle?.set("registered_user", user)

            showSuccess("Регистрация успешна!")
            
            // Возвращаемся к экрану входа
            findNavController().navigateUp()
        }
    }

    private fun validateInput(
        name: String,
        email: String,
        password: String,
        confirmPassword: String,
        age: String,
        phone: String,
        gender: String
    ): Boolean {
        return when {
            name.isEmpty() -> {
                showError("Пожалуйста, введите имя")
                false
            }
            name.length < 2 -> {
                showError("Имя должно содержать минимум 2 символа")
                false
            }
            email.isEmpty() -> {
                showError("Пожалуйста, введите email")
                false
            }
            !email.contains("@") || !email.contains(".") -> {
                showError("Пожалуйста, введите корректный email")
                false
            }
            password.isEmpty() -> {
                showError("Пожалуйста, введите пароль")
                false
            }
            password.length < 6 -> {
                showError("Пароль должен содержать минимум 6 символов")
                false
            }
            password != confirmPassword -> {
                showError("Пароли не совпадают")
                false
            }
            age.isEmpty() -> {
                showError("Пожалуйста, введите возраст")
                false
            }
            age.toIntOrNull() == null || age.toInt() < 16 || age.toInt() > 120 -> {
                showError("Возраст должен быть от 16 до 120 лет")
                false
            }
            phone.isEmpty() -> {
                showError("Пожалуйста, введите телефон")
                false
            }
            phone.length < 10 -> {
                showError("Телефон должен содержать минимум 10 цифр")
                false
            }
            gender.isEmpty() -> {
                showError("Пожалуйста, выберите пол")
                false
            }
            else -> true
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showSuccess(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}