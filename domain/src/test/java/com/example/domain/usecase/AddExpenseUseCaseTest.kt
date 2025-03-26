package com.example.domain.usecase

import com.example.domain.entity.Expense
import com.example.domain.repository.ExpenseRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AddExpenseUseCaseTest{
    private lateinit var useCase: AddExpenseUseCase
//    private lateinit var repository: ExpenseRepository
    private lateinit var  fakeRepository : FakeExpenseRepository
    @Before
    fun setUp(){
//        repository = mockk(relaxed = true)
        fakeRepository = FakeExpenseRepository()
        useCase = AddExpenseUseCase(fakeRepository)
    }

    @Test
    fun `invoke should call repositoryFake with correct parameters`() = runBlocking{
        val expense = expenseMock
        useCase(expense)
        val expenses = fakeRepository.getAllExpenses()
        assertTrue(expenses.contains(expense))
    }

    @Test
    fun `invoke should add multiple expenses to fake repository`() = runBlocking{

    }

    companion object{
        val expenseMock = Expense(
            4,
            "TESTE",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        val expenseMock2 = Expense(
            5,
            "TESTE2",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )
    }
}