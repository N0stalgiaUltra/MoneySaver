package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entity.ExpenseLocal
import com.example.domain.model.Expense

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertExpense(expense: ExpenseLocal)

    @Query("DELETE FROM expenses WHERE id = :id")
    fun removeExpenseUseCase(id: Long)

    @Query("SELECT * FROM expenses")
    fun getAllExpenses() : List<Expense>

    @Query("SELECT * FROM expenses WHERE id = :id")
    fun getExpense(id: Long) : Expense
}