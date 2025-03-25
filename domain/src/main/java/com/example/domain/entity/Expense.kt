package com.example.domain.entity

data class Expense(
    val id: Long,
    val name: String,
    val amount: Double,
    val date: String,
    val category: String,
    val description: String
)
