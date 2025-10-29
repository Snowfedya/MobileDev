package com.example.restaurantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuCategory(
    val name: String,
    val dishes: List<Dish>
) : Parcelable
