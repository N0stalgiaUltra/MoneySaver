package com.example.database.repository

import com.example.database.dao.ExpenseDao
import com.example.database.mapper.ExpenseMapper
import com.example.domain.datasource.LocalDataSource
import com.example.domain.model.Expense

class LocalDataSourceImpl(private val dao: ExpenseDao): LocalDataSource {
    override fun insert(expense: Expense) {
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)
        dao.insertExpense(expenseLocal)
    }

    override fun remove(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getItems(): List<Expense> {
        TODO("Adicionar o mapper do metodo")
    }

    override fun getItem(id: Long): Expense {
        TODO("Adicionar o mapper do metodo")
    }


}