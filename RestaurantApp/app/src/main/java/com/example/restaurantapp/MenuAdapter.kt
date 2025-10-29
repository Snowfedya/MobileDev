package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(
    private val menuCategories: List<MenuCategory>,
    private val onItemClick: (MenuCategory) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuCategories[position])
    }

    override fun getItemCount(): Int {
        return menuCategories.size
    }

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val menuItemTextView: TextView = itemView.findViewById(R.id.menuItemTextView)

        fun bind(menuCategory: MenuCategory) {
            menuItemTextView.text = menuCategory.name
            itemView.setOnClickListener {
                onItemClick(menuCategory)
            }
        }
    }
}
