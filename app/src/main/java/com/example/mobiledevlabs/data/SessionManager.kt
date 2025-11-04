package com.example.mobiledevlabs.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SessionManager(context: Context) {

    private val sharedPreferences: SharedPreferences
    private val gson = Gson()

    companion object {
        private const val PREFS_NAME = "app_session"
        private const val KEY_USER = "user"
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
    }

    init {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Saves the user object and sets the login status to true.
     */
    fun saveUser(user: User) {
        val userJson = gson.toJson(user)
        sharedPreferences.edit().apply {
            putString(KEY_USER, userJson)
            putBoolean(KEY_IS_LOGGED_IN, true)
            apply()
        }
    }

    /**
     * Retrieves the logged-in user.
     * @return The [User] object if logged in, otherwise null.
     */
    fun getUser(): User? {
        val userJson = sharedPreferences.getString(KEY_USER, null)
        return gson.fromJson(userJson, User::class.java)
    }

    /**
     * Checks if a user is currently logged in.
     * @return True if logged in, false otherwise.
     */
    fun isUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    /**
     * Clears all session data and logs the user out.
     */
    fun logout() {
        sharedPreferences.edit().clear().apply()
    }
}
