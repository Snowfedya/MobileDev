package com.example.mobiledevlabs.ui.home

import android.os.Bundle
import androidx.navigation.fragment.navArgs
import com.example.mobiledevlabs.databinding.FragmentHomeBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val args: HomeFragmentArgs by navArgs()

    override fun handleArguments(arguments: Bundle?) {
        super.handleArguments(arguments)
        val user = args.user
        binding.welcomeTextView.text = "Welcome, ${user.username}!"
    }
}
