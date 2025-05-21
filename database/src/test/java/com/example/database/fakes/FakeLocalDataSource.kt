package com.example.database.fakes

import com.example.domain.datasource.LocalDataSource
import com.example.domain.model.Expense
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeLocalDataSource : LocalDataSource {
    private val expenses = mutableListOf<Expense>()

    override suspend fun insert(expense: Expense) {
        withContext(Dispatchers.IO){
            expenses.add(expense)
        }
    }

    override suspend fun remove(id: Long) {
        withContext(Dispatchers.IO){
            expenses.remove(
                expenses.find {
                    it.id == id
                }
            )
        }
    }

    override suspend fun getItems(): List<Expense> {
        return expenses
    }

    override suspend fun getItem(id: Long): Expense {
        val expense = expenses.find {
            it.id == id
        }
        return expense!! //guaranteeing not null
    }
}