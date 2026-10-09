package com.example.database.fakes

import com.example.database.entity.ExpenseLocal
import com.example.domain.model.Expense

object ExpenseFakes {

    fun expense(
        id: Long = 1L,
        name: String = "Food",
        amount: Double = 100.0,
        date: String = "27/03/2025",
        category: String = "TESTE",
        description: String = ""
    ) = Expense(id, name, amount, date, category, description)

    fun expenseLocal(
        id: Long = 1L,
        name: String = "Food",
        amount: Double = 100.0,
        date: String = "27/03/2025",
        category: String = "TESTE",
        description: String = ""
    ) = ExpenseLocal(id, name, amount, date, category, description)

    val DEFAULT_EXPENSE = expense()
    val DEFAULT_EXPENSE_LOCAL = expenseLocal()

    val EXPENSE_WITH_EMPTY_DESCRIPTION = expense(description = "")
    val EXPENSE_LOCAL_WITH_EMPTY_DESCRIPTION = expenseLocal(description = "")

    val EXPENSE_WITH_DECIMAL_PRECISION = expense(amount = 99.999999)
    val EXPENSE_LOCAL_WITH_DECIMAL_PRECISION = expenseLocal(amount = 99.999999)

    val EXPENSE_WITH_NEGATIVE_AMOUNT = expense(amount = -50.0)
    val EXPENSE_LOCAL_WITH_NEGATIVE_AMOUNT = expenseLocal(amount = -50.0)

    val EXPENSE_WITH_SPECIAL_CHARACTERS = expense(
        name = "Café & Açaí",
        category = "Lazer/Saúde",
        description = "R\$ gasto em \"doces\""
    )
    val EXPENSE_LOCAL_WITH_SPECIAL_CHARACTERS = expenseLocal(
        name = "Café & Açaí",
        category = "Lazer/Saúde",
        description = "R\$ gasto em \"doces\""
    )

    val EXPENSE_WITH_ZERO_ID = expense(id = 0L)
    val EXPENSE_LOCAL_WITH_ZERO_ID = expenseLocal(id = 0L)
}
