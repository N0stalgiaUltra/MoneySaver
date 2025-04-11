package com.example.domain.datasource

import com.example.domain.model.Expense

interface LocalDataSource {
    fun insert(expense: Expense)
    fun remove(id: Long)
    fun getItems(): List<Expense>
    fun getItem(id: Long): Expense

}