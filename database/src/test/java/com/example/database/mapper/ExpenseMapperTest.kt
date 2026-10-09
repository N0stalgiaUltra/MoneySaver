package com.example.database.mapper

import com.example.database.fakes.ExpenseFakes
import org.junit.Assert.assertEquals
import org.junit.Test

class ExpenseMapperTest {

    @Test
    fun `Roundtrip test`(){
        val expenseOriginal = ExpenseFakes.expense()

        val expenseLocal = ExpenseMapper.toExpenseLocal(expenseOriginal)
        val expenseRecovered = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseOriginal, expenseRecovered)
    }

    @Test
    fun `Roundtrip test starting from ExpenseLocal`(){
        val expenseLocalOriginal = ExpenseFakes.expenseLocal()

        val expense = ExpenseMapper.toExpense(expenseLocalOriginal)
        val expenseLocalRecovered = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expenseLocalOriginal, expenseLocalRecovered)
    }

    @Test
    fun `Should map from Expense to ExpenseLocal`() {
        val expense = ExpenseFakes.expense()
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }

    @Test
    fun `Should map from Expense to ExpenseLocal even with id equals to zero`(){
        val expense = ExpenseFakes.EXPENSE_WITH_ZERO_ID
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }

    @Test
    fun `Should map from Expense to ExpenseLocal even with empty description`(){
        val expense = ExpenseFakes.EXPENSE_WITH_EMPTY_DESCRIPTION
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }

    @Test
    fun `Should map from Expense to ExpenseLocal even with decimal precision`(){
        val expense = ExpenseFakes.EXPENSE_WITH_DECIMAL_PRECISION
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }

    @Test
    fun `Should map from Expense to ExpenseLocal even with negative amount`(){
        val expense = ExpenseFakes.EXPENSE_WITH_NEGATIVE_AMOUNT
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }
    @Test
    fun `Should map from Expense to ExpenseLocal even with special characters`(){
        val expense = ExpenseFakes.EXPENSE_WITH_SPECIAL_CHARACTERS
        val expenseLocal = ExpenseMapper.toExpenseLocal(expense)

        assertEquals(expense.id, expenseLocal.id)
        assertEquals(expense.description, expenseLocal.description)
        assertEquals(expense.amount, expenseLocal.amount, 0.0001)
        assertEquals(expense.date, expenseLocal.date)
        assertEquals(expense.name, expenseLocal.name)
        assertEquals(expense.category, expenseLocal.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense`() {
        val expenseLocal = ExpenseFakes.expenseLocal()
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense even with id equals to zero`(){
        val expenseLocal = ExpenseFakes.EXPENSE_LOCAL_WITH_ZERO_ID
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense even with empty description`(){
        val expenseLocal = ExpenseFakes.EXPENSE_LOCAL_WITH_EMPTY_DESCRIPTION
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense even with decimal precision`(){
        val expenseLocal = ExpenseFakes.EXPENSE_LOCAL_WITH_DECIMAL_PRECISION
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense even with negative amount`(){
        val expenseLocal = ExpenseFakes.EXPENSE_LOCAL_WITH_NEGATIVE_AMOUNT
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

    @Test
    fun `Should map from ExpenseLocal to Expense even with special characters`(){
        val expenseLocal = ExpenseFakes.EXPENSE_LOCAL_WITH_SPECIAL_CHARACTERS
        val expense = ExpenseMapper.toExpense(expenseLocal)

        assertEquals(expenseLocal.id, expense.id)
        assertEquals(expenseLocal.description, expense.description)
        assertEquals(expenseLocal.amount, expense.amount, 0.0001)
        assertEquals(expenseLocal.date, expense.date)
        assertEquals(expenseLocal.name, expense.name)
        assertEquals(expenseLocal.category, expense.category)
    }

}