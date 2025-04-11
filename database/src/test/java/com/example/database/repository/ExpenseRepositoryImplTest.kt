package com.example.database.repository

import com.example.database.fakes.FakeLocalDataSource
import com.example.domain.model.Expense
import com.example.domain.repository.ExpenseRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ExpenseRepositoryImplTest {
    private lateinit var repository : ExpenseRepository
    private lateinit var dataSource : FakeLocalDataSource

    @Before
    fun setUp() {
        dataSource = FakeLocalDataSource()
        repository = ExpenseRepositoryImpl(dataSource)
    }

    @Test
    fun `addExpense should add an expense`() = runBlocking{
        val expense = Expense(
            0, "Teste", 10.0, "2023-01-01", "Food")

        val resultAdd = repository.addExpense(expense)
        assertTrue(resultAdd.isSuccess)
        assertEquals(resultAdd.success.data, Unit)

        val resultGetAllExpenses = repository.getAllExpenses()
        assertTrue(resultGetAllExpenses.isSuccess)
        assertEquals(resultGetAllExpenses.success.data.first(), expense)
//        assertEquals(resultGetAllExpenses.success, DataResult.Success)

    }

    @Test
    fun `getAllExpenses should return a list of expenses`() = runBlocking{
        val expense = Expense(
            0, "Teste", 10.0, "2023-01-01", "Food")
        val expense2 = Expense(
            1, "Teste", 10.0, "2023-01-01", "Food")
        repository.addExpense(expense)
        repository.addExpense(expense2)

        val resultGetAllExpenses = repository.getAllExpenses()
        assertTrue(resultGetAllExpenses.isSuccess)
        assertEquals(resultGetAllExpenses.success.data.size, 2)
    }


}