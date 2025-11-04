package com.example.restaurantapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.restaurantapp.databinding.ActivitySignupBinding

class SignUpActivity : BaseActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && email.contains("@")) {
                val user = User(name, email, password)
                val resultIntent = Intent()
                resultIntent.putExtra("USER_EMAIL", email)
                resultIntent.putExtra("USER_OBJECT", user)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                // Show error
            }
        }
    }
}
