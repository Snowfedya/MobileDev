package com.example.mobiledevlabs.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.mobiledevlabs.utils.LoggingUtils

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : Fragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoggingUtils.i("Lifecycle event")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LoggingUtils.i("Lifecycle event")
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LoggingUtils.i("Lifecycle event")
        handleArguments(arguments)
        setupUI()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        LoggingUtils.i("Lifecycle event")
    }

    override fun onPause() {
        super.onPause()
        LoggingUtils.i("Lifecycle event")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LoggingUtils.i("Lifecycle event")
        _binding = null
    }

    open fun handleArguments(arguments: Bundle?) {
        // Can be overridden by subclasses
    }

    open fun setupUI() {
        // Can be overridden by subclasses to setup UI elements
    }

    open fun observeViewModel() {
        // Can be overridden by subclasses to observe LiveData
    }
}
