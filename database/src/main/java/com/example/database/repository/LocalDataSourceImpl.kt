package com.example.database.repository

import com.example.database.dao.ExpenseDao
import com.example.database.mapper.ExpenseMapper
import com.example.domain.datasource.LocalDataSource
import com.example.domain.model.Expense
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSourceImpl(private val dao: ExpenseDao): LocalDataSource {
    override suspend fun insert(expense: Expense) {
        withContext(Dispatchers.IO) {
            val expenseLocal = ExpenseMapper.toExpenseLocal(expense)
            dao.insertExpense(expenseLocal)
        }
    }

    override suspend fun remove(id: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(): List<Expense> {
        TODO("Adicionar o mapper do metodo")
    }

    override suspend fun getItem(id: Long): Expense {
        TODO("Adicionar o mapper do metodo")
    }


}