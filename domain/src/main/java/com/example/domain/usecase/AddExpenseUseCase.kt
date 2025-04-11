package com.example.domain.usecase

import com.example.domain.dataresult.DataResult
import com.example.domain.model.Expense
import com.example.domain.repository.ExpenseRepository

class AddExpenseUseCase(private val repository: ExpenseRepository) {
    suspend operator fun invoke(expense: Expense): DataResult<Unit> {
        if(expense.name.isBlank() || expense.amount <= 0){
            return DataResult.Failure(IllegalArgumentException
                ("Invalid Expense"))
        }

        return try {
            repository.addExpense(expense)
            DataResult.Success(Unit)
        } catch (e: Exception) {
            DataResult.Failure(e)
        }
    }
}