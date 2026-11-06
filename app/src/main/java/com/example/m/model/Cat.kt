package com.example.m.model

data class Cat(
    val id: Int,
    val name: String,
    val breed: String,
    val gender: String,
    val age: String,
    val condition: String,
    val description: String,
    val imageResId: Int,
    var isFavorite: Boolean = false
)