package com.example.domain.usecase

import com.example.domain.dataresult.DataResult
import com.example.domain.entity.Expense
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

        val result = useCase(expense)
        val expenses = fakeRepository.getAllExpenses()

        assertTrue(expenses.contains(expense))
        assertTrue(result is DataResult.Success)
        assertEquals(Unit, (result as DataResult.Success).data)
    }

    @Test
    fun `invoke should add multiple expenses to fake repository`() = runBlocking{
        val expense = expenseMock
        val expense2 = expenseMock2

        val result = useCase(expense)
        val result2 = useCase(expense2)

        val expenses = fakeRepository.getAllExpenses()

        assertTrue(expenses.contains(expense))
        assertTrue(expenses.contains(expense2))

        assertTrue(result is DataResult.Success)
        assertTrue(result2 is DataResult.Success)

        assertEquals(Unit, (result as DataResult.Success).data)
        assertEquals(Unit, (result2 as DataResult.Success).data)
    }

    @Test
    fun `invoke should return an IllegalArgumentException when expense amount is minor or equal to zero`() = runBlocking {
        val expense = noAmountExpense

        val result = useCase(expense)

        assertTrue(result is DataResult.Failure)
        assertTrue((result as DataResult.Failure).throwable is IllegalArgumentException)
        assertEquals("Invalid Expense", result.throwable?.message)
    }

    @Test
    fun `invoke should return an IllegalArgumentException when expense name is empty`() = runBlocking {
        val expense = noNameExpense

        val result = useCase(expense)

        assertTrue(result is DataResult.Failure)
        assertTrue((result as DataResult.Failure).throwable is IllegalArgumentException)
        assertEquals("Invalid Expense", result.throwable?.message)
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
            4,
            "TESTE",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        val noAmountExpense = Expense(
            5,
            "TESTE2",
            0.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        val noNameExpense = Expense(
            6,
            "",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )
    }
}