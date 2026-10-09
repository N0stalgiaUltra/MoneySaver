package com.example.domain.repository

import com.example.domain.dataresult.DataResult
import com.example.domain.model.Expense

interface ExpenseRepository {
    suspend fun addExpense(item: Expense) : DataResult<Unit>
    suspend fun removeExpense(id: Long) : DataResult<Unit>
    suspend fun getExpense(id: Long): DataResult<Expense?>
    suspend fun getAllExpenses(): DataResult<List<Expense>>
}