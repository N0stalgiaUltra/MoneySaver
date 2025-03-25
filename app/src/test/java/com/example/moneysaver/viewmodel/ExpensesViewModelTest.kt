package com.example.moneysaver.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.entity.Expense
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test

class ExpensesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ExpensesViewModel
    /**
     * 1- Mockar a viewModel
     * 2- Mockar uma lista de expenses/despesas
     * 3- Mockar um expense/despesa
     * 4- Casos de teste
     */

    @Before
    fun setUp() {
        viewModel = ExpensesViewModel()
    }


    @Test
    fun `given a new view model, should provide an initial empty list state`(){
        val actualList = viewModel.expensesList.value
        assert(actualList.isNullOrEmpty())
    }

    @Test
    fun `when addExpense is called, the list should add the expense`(){
        assert(viewModel.expensesList.value.isNullOrEmpty())

        val expense = Expense(
            0,
            "Celular",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        viewModel.addExpense(expense)
        val actualList = viewModel.expensesList.value
        assertTrue(actualList!!.isNotEmpty())
        assertTrue(
            actualList.contains(expense)
        )
    }
}