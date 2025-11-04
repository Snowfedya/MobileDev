package com.example.mobiledevlabs.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobiledevlabs.R
import com.example.mobiledevlabs.data.SessionManager
import com.example.mobiledevlabs.databinding.FragmentHomeBinding
import com.example.mobiledevlabs.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val args: HomeFragmentArgs by navArgs()
    private lateinit var sessionManager: SessionManager
    // In a real app, this would be populated from a data source
    private val chatAdapter = ChatAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(requireContext())
        setHasOptionsMenu(true)
    }

    override fun setupUI() {
        super.setupUI()
        setupRecyclerView()
        checkEmptyState()

        binding.fab.setOnClickListener {
            // Handle new chat creation
        }
    }

    private fun setupRecyclerView() {
        binding.chatsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chatAdapter
        }
    }

    private fun checkEmptyState() {
        if (chatAdapter.itemCount == 0) {
            binding.chatsRecyclerView.visibility = View.GONE
            binding.emptyStateTextView.visibility = View.VISIBLE
        } else {
            binding.chatsRecyclerView.visibility = View.VISIBLE
            binding.emptyStateTextView.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                sessionManager.logout()
                findNavController().navigate(HomeFragmentDirections.actionGlobalOnboardFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
// Dummy adapter for compilation. A real implementation would be needed.
class ChatAdapter(private val items: List<String>) : androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        return object : androidx.recyclerview.widget.RecyclerView.ViewHolder(android.widget.TextView(parent.context)) {}
    }
    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {}
    override fun getItemCount(): Int = items.size
}
