package com.example.mobiledevlabs.data

import android.os.Parcelable
import android.util.Patterns
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Long,
    val username: String,
    val email: String,
    val password: String, // Note: Storing passwords in plaintext is insecure. This is for educational purposes only.
    val gender: Gender,
    val age: Int,
    val createdAt: Long = System.currentTimeMillis()
) : Parcelable {

    enum class Gender {
        MALE, FEMALE, OTHER
    }

    /**
     * Validates the user's registration data.
     * @return A map of validation errors, where the key is the field name and the value is the error message.
     * An empty map indicates that the data is valid.
     */
    fun validateForRegistration(): Map<String, String> {
        val errors = mutableMapOf<String, String>()

        if (username.isBlank()) {
            errors["username"] = "Username cannot be empty."
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            errors["email"] = "Invalid email address."
        }

        if (password.length < 8) {
            errors["password"] = "Password must be at least 8 characters long."
        }

        if (age < 18) {
            errors["age"] = "You must be at least 18 years old."
        }

        return errors
    }

    companion object {
        /**
         * Provides example User objects for testing and previews.
         */
        fun getSampleUsers(): List<User> {
            return listOf(
                User(1L, "John Doe", "john.doe@example.com", "password123", Gender.MALE, 28),
                User(2L, "Jane Smith", "jane.smith@example.com", "securepass", Gender.FEMALE, 34),
                User(3L, "Alex Ray", "alex.ray@example.com", "alex@123", Gender.OTHER, 22)
            )
        }
    }
}
