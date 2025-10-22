package com.example.taskmaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskmaster.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment() {

    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("OnboardFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        Log.d("OnboardFragment", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("OnboardFragment", "onViewCreated")

        binding.nextButton.setOnClickListener {
            (activity as? MainActivity)?.navigateToSignIn()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnboardFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnboardFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnboardFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnboardFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("OnboardFragment", "onDestroyView")
    }
}
