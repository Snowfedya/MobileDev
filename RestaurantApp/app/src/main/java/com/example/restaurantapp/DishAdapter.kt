package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishAdapter(
    private val dishes: List<Dish>,
    private val onItemClick: (Dish) -> Unit
) : RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dish, parent, false)
        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    inner class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dishImageView: ImageView = itemView.findViewById(R.id.dishImageView)
        private val dishNameTextView: TextView = itemView.findViewById(R.id.dishNameTextView)

        fun bind(dish: Dish) {
            dishImageView.setImageResource(dish.imageResource)
            dishNameTextView.text = dish.name
            itemView.setOnClickListener {
                onItemClick(dish)
            }
        }
    }
}
