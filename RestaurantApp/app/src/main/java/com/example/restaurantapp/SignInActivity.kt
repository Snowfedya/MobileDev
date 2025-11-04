package com.example.restaurantapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.restaurantapp.databinding.ActivitySigninBinding

class SignInActivity : BaseActivity() {

    private lateinit var binding: ActivitySigninBinding

    private val signUpLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val email = data?.getStringExtra("USER_EMAIL")
            val user = data?.getParcelableExtra<User>("USER_OBJECT")

            binding.emailEditText.setText(email)
            // The name is in the user object, but there is no field for it in the sign-in screen.
            // I will set the password field with the user's name for demonstration purposes as requested.
            binding.passwordEditText.setText(user?.name)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                // Show error
            }
        }

        binding.registerButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpLauncher.launch(intent)
        }
    }
}
