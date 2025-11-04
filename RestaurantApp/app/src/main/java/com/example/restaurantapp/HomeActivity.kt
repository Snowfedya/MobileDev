package com.example.restaurantapp

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantapp.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val menu = createFakeMenu()
        val adapter = DishAdapter(menu)

        binding.recyclerViewMenu.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMenu.adapter = adapter
    }

    private fun createFakeMenu(): List<Dish> {
        // Используем реальные изображения из res/drawable
        return listOf(
            Dish(1, "Margherita Pizza", "Томаты, моцарелла, базилик", 12.50,
                 R.drawable.margherita_pizza),

            Dish(2, "Grilled Salmon", "Стейк лосося с овощами", 18.00,
                 R.drawable.grilled_salmon),

            Dish(3, "Bruschetta", "Тосты с томатами и базиликом", 7.50,
                 R.drawable.bruschetta),

            Dish(4, "Caprese Salad", "Моцарелла, томаты, базилик", 9.00,
                 R.drawable.caprese_salad),

            Dish(5, "Chocolate Cake", "Насыщенный шоколадный десерт", 6.50,
                 R.drawable.chocolate_cake),

            Dish(6, "Garlic Bread", "Чесночный хлеб", 4.00,
                 R.drawable.garlic_bread)
        )
    }
}