package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entity.ExpenseLocal

@Dao
interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertExpense(expense: ExpenseLocal)

    @Query("DELETE FROM expenses WHERE id = :id")
    suspend fun removeExpenseUseCase(id: Long)

    @Query("SELECT * FROM expenses")
    suspend fun getAllExpenses() : List<ExpenseLocal>

    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpense(id: Long) : ExpenseLocal
}