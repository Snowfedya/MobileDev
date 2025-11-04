package com.example.mobiledevlabs.ui.home

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.mobiledevlabs.databinding.FragmentHomeBinding
import com.example.mobiledevlabs.ui.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    // --- Safe Args: Receiving data in Home ---
    private val args: HomeFragmentArgs by navArgs()

    override fun handleArguments(arguments: Bundle?) {
        super.handleArguments(arguments)
        val user = args.user

        val dateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
        val creationDate = dateFormat.format(Date(user.createdAt))

        val welcomeMessage = """
            Welcome, ${user.username}!

            ID: ${user.id}
            Email: ${user.email}
            Gender: ${user.gender}
            Age: ${user.age}
            Member Since: $creationDate
        """.trimIndent()

        binding.welcomeTextView.text = welcomeMessage
    }
}
