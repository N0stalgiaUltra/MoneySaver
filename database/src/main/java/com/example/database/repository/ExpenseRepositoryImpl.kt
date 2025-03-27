package com.example.database.repository

import android.provider.ContactsContract.Data
import com.example.domain.dataresult.DataResult
import com.example.domain.datasource.LocalDataSource
import com.example.domain.entity.Expense
import com.example.domain.repository.ExpenseRepository

class ExpenseRepositoryImpl(private val dataSource: LocalDataSource) : ExpenseRepository {
    override suspend fun addExpense(item: Expense): DataResult<Unit> {
        return try{
            dataSource.insert(item)
            DataResult.Success(Unit)
        }catch (e: Exception){
            DataResult.Failure(e)
        }
    }

    override suspend fun removeExpense(id: Long): DataResult<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun getExpense(id: Long): DataResult<Expense?> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExpenses(): DataResult<List<Expense>> {
        return try {
            val expenses = dataSource.getItems()
            DataResult.Success(expenses)
        }catch (e: Exception){
            DataResult.Failure(e)
        }
    }
}