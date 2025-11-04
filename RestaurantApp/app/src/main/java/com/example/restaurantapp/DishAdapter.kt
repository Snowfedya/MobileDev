package com.example.restaurantapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantapp.databinding.ItemDishBinding // Убедись, что твой layout называется item_dish.xml

class DishAdapter(private val dishes: List<Dish>) :
    RecyclerView.Adapter<DishAdapter.DishViewHolder>() {

    /**
     * ViewHolder (Держатель Элемента)
     * Он хранит ссылки на View (через binding) и имеет метод .bind()
     */
    class DishViewHolder(private val binding: ItemDishBinding) : RecyclerView.ViewHolder(binding.root) {
        
        // Этот метод связывает данные (Dish) с UI (binding)
        fun bind(dish: Dish) {
            binding.dishName.text = dish.name
            binding.dishDescription.text = dish.description
            binding.dishPrice.text = "$${dish.price}" // Форматируем цену
            
            // !!! В ЭТОЙ СТРОКЕ БЫЛА ОШИБКА (ОНА ОТСУТСТВОВАЛА) !!!
            binding.dishImage.setImageResource(dish.imageResId) 
        }
    }

    /**
     * Вызывается, когда RecyclerView нужен новый ViewHolder (новая карточка)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = ItemDishBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DishViewHolder(binding)
    }

    /**
     * Вызывается, чтобы отобразить данные в конкретной позиции (связать ViewHolder)
     */
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(dishes[position]) // Вызываем наш метод bind()
    }

    /**
     * Сообщает RecyclerView, сколько всего элементов в списке
     */
    override fun getItemCount() = dishes.size
}