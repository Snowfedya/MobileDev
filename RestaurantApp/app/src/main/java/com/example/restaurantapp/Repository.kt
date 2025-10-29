package com.example.restaurantapp

object Repository {

    fun getMenuCategories(): List<MenuCategory> {
        return listOf(
            MenuCategory(
                "Appetizers",
                listOf(
                    Dish("Bruschetta", "Toasted bread with tomatoes, garlic, and basil.", R.drawable.bruschetta),
                    Dish("Caprese Salad", "Fresh mozzarella, tomatoes, and basil.", R.drawable.caprese_salad),
                    Dish("Garlic Bread", "Buttery garlic bread.", R.drawable.garlic_bread)
                )
            ),
            MenuCategory(
                "Main Courses",
                listOf(
                    Dish("Spaghetti Carbonara", "Pasta with eggs, cheese, and pancetta.", R.drawable.spaghetti_carbonara),
                    Dish("Margherita Pizza", "Pizza with tomatoes, mozzarella, and basil.", R.drawable.margherita_pizza),
                    Dish("Grilled Salmon", "Grilled salmon with a lemon-dill sauce.", R.drawable.grilled_salmon)
                )
            ),
            MenuCategory(
                "Desserts",
                listOf(
                    Dish("Tiramisu", "Coffee-flavored Italian dessert.", R.drawable.tiramisu),
                    Dish("Panna Cotta", "Italian dessert of sweetened cream.", R.drawable.panna_cotta),
                    Dish("Chocolate Cake", "Rich chocolate cake.", R.drawable.chocolate_cake)
                )
            )
        )
    }
}
