package com.example.mobiledevlabs.ui.onboard

import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.databinding.FragmentOnboardBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class OnboardFragment : BaseFragment<FragmentOnboardBinding>(FragmentOnboardBinding::inflate) {

    override fun setupUI() {
        super.setupUI()
        binding.nextButton.setOnClickListener {
            findNavController().navigate(OnboardFragmentDirections.actionOnboardFragmentToSignInFragment())
        }
    }
}
