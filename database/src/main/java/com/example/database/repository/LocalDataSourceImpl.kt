package com.example.database.repository

import com.example.database.dao.ExpenseDao
import com.example.domain.datasource.LocalDataSource
import com.example.domain.entity.Expense
import kotlin.math.exp

class LocalDataSourceImpl(private val dao: ExpenseDao): LocalDataSource {
    override fun insert(expense: Expense) {
        dao.insertExpense(expense)
    }

    override fun remove(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getItems(): List<Expense> {
        TODO("Not yet implemented")
    }

    override fun getItem(id: Long): Expense {
        TODO("Not yet implemented")
    }


}