package com.example.restaurantapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val name: String,
    val description: String,
    val imageResource: Int
) : Parcelable
