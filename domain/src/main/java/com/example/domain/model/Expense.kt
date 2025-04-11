package com.example.domain.model

data class Expense(
    val id: Long,
    val name: String,
    val amount: Double,
    val date: String,
    val category: String,
    val description: String = ""
)
