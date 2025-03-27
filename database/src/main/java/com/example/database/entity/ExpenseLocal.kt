package com.example.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Expenses")
data class ExpenseLocal(
    @PrimaryKey val id: Long,
    val name : String,
    val amount: Double,
    val date: String,
    val category: String,
    val description: String = ""
)
