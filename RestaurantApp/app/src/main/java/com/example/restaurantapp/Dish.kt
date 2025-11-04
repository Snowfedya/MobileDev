package com.example.restaurantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageResId: Int
) : Parcelable
