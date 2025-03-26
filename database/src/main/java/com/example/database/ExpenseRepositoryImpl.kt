package com.example.database

import com.example.domain.entity.Expense
import com.example.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl() : ExpenseRepository {
    override suspend fun addExpense(item: Expense) {
        TODO("Not yet implemented")
    }

    override suspend fun removeExpense(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getExpense(id: Long): Expense? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExpenses(): List<Expense> {
        TODO("Not yet implemented")
    }
}