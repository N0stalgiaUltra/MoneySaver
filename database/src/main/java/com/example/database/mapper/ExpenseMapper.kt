package com.example.database.mapper

import com.example.database.entity.ExpenseLocal
import com.example.domain.entity.Expense

object ExpenseMapper {
    fun toExpenseLocal(expense: Expense): ExpenseLocal{
        return ExpenseLocal(
            id = expense.id,
            name = expense.name,
            amount = expense.amount,
            date = expense.date,
            category = expense.category,
            description = expense.description
        )

    }
    fun toExpense(expenseLocal: ExpenseLocal): Expense{
        return Expense(
            id = expenseLocal.id,
            name = expenseLocal.name,
            amount = expenseLocal.amount,
            date = expenseLocal.date,
            category = expenseLocal.category,
            description = expenseLocal.description
        )
    }
}