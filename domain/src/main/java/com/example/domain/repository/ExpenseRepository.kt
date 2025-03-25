package com.example.domain.repository

import com.example.domain.entity.Expense

interface ExpenseRepository {
    suspend fun addExpense(item: Expense)
    suspend fun removeExpense(id: Long)
    suspend fun getExpense(id: Long): Expense?
    suspend fun getallExpenses(): List<Expense>
}