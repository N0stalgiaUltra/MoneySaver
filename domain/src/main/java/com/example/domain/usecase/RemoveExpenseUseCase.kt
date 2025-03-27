package com.example.domain.usecase

import com.example.domain.dataresult.DataResult
import com.example.domain.repository.ExpenseRepository

class RemoveExpenseUseCase(private val repository: ExpenseRepository) {
    suspend operator fun invoke(id: Long): DataResult<Unit> {
        repository.removeExpense(id)
        return DataResult.Success(Unit)
    }
}