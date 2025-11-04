package com.example.mobiledevlabs.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email: String,
    val username: String
) : Parcelable
