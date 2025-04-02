package com.example.domain.usecase

import android.provider.ContactsContract.Data
import com.example.domain.dataresult.DataResult
import com.example.domain.entity.Expense
import com.example.domain.repository.ExpenseRepository
import kotlin.math.exp

class FakeExpenseRepository: ExpenseRepository {
    private var expenses = mutableListOf<Expense>()

    override suspend fun addExpense(item: Expense): DataResult<Unit> {
        try{
            expenses.add(item)
            return DataResult.Success(Unit)
        }catch (e: Exception){
            return DataResult.Failure(e)
        }
    }

    override suspend fun removeExpense(id: Long): DataResult<Unit> {
        try{
            expenses.remove(
                expenses.find {
                    it.id == id
                }
            )
            return DataResult.Success(Unit)
        }catch (e: Exception){
            return DataResult.Failure(e)
        }
    }

    override suspend fun getExpense(id: Long): DataResult<Expense?> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExpenses(): DataResult<List<Expense>> {
        try {
            return DataResult.Success(expenses)
        }catch (e: Exception){
            return DataResult.Failure(e)
        }
    }


    /**
     *  Methods created for test purpose only
     * */
    fun clearExpenses() {
        expenses.clear()
    }

    fun fillExpenseList(){
        expenses = listOf(
            Expense(
                0,
                "Celular",
                100.00,
                "03/02/1998",
                "Despesas",
                "Celular Novo"
            ), Expense(
                1,
                "Chuteira",
                500.00,
                "03/02/2023",
                "Custos Simples",
                "Chuteira nova"
            ), Expense(
                2,
                "Plano de saude",
                450.00,
                "01/12/2005",
                "Despesas",
                "Plano de saude novo"
            ),
        ).toMutableList()
    }
}