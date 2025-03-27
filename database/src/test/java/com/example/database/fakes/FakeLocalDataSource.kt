package com.example.database.fakes

import com.example.domain.datasource.LocalDataSource
import com.example.domain.entity.Expense

class FakeLocalDataSource : LocalDataSource {
    private val expenses = mutableListOf<Expense>()

    override fun insert(expense: Expense) {
        expenses.add(expense)
    }

    override fun remove(id: Long) {
        expenses.remove(
            expenses.find {
                it.id == id
            }
        )
    }

    override fun getItems(): List<Expense> {
        return expenses
    }

    override fun getItem(id: Long): Expense {
        val expense = expenses.find {
            it.id == id
        }
        return expense!! //guaranteeing not null
    }
}