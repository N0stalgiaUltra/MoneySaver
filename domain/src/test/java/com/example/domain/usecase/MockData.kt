package com.example.domain.usecase

import com.example.domain.entity.Expense
import com.example.domain.repository.ExpenseRepository
import kotlin.math.exp

class FakeExpenseRepository: ExpenseRepository {
    private var expenses = mutableListOf<Expense>()

    override suspend fun addExpense(item: Expense) {
        expenses.add(item)
    }

    override suspend fun removeExpense(id: Long) {
        expenses.remove(
            expenses.find {
                it.id == id
            }
        )
    }

    override suspend fun getExpense(id: Long): Expense? {
        TODO("Not yet implemented")
    }

    override suspend fun getAllExpenses(): List<Expense> {
        return expenses;
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