package com.example.taskmaster

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskmaster.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        Log.d("HomeFragment", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "onViewCreated")

        val tasks = listOf(
            Task(1, "Implement Feature X", "As a user, I want to be able to...", "2023-11-15"),
            Task(2, "Fix Bug Y", "The app crashes when...", "2023-11-20"),
            Task(3, "Refactor Z", "The code in this module is...", "2023-11-25")
        )

        binding.tasksRecyclerView.apply {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = TaskAdapter(tasks)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeFragment", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeFragment", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeFragment", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("HomeFragment", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("HomeFragment", "onDestroyView")
    }
}
