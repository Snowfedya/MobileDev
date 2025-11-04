package com.example.mobiledevlabs.ui.onboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mobiledevlabs.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {

    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("OnboardFragment", "onCreateView")
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("OnboardFragment", "onViewCreated")
        binding.nextButton.setOnClickListener {
            findNavController().navigate(OnboardFragmentDirections.actionOnboardFragmentToSignInFragment())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("OnboardFragment", "onDestroyView")
        _binding = null
    }
}
