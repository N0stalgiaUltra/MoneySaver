package com.example.domain.datasource

import com.example.domain.model.Expense

interface LocalDataSource {
    suspend fun insert(expense: Expense)
    suspend fun remove(id: Long)
    suspend fun getItems(): List<Expense>
    suspend fun getItem(id: Long): Expense

}