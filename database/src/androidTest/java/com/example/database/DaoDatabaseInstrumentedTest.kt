package com.example.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.database.dao.ExpenseDao
import com.example.database.repository.LocalDataSourceImpl
import com.example.domain.datasource.LocalDataSource
import com.example.domain.entity.Expense
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocalDataSourceImplTest {
    private lateinit var database: AppDatabase
    private lateinit var dao : ExpenseDao
    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.expenseDao()
    }



    @Test
    fun addExpense_should_insert_into_Database(){
        val expense = Expense(1, "Food",
            100.0, "27/03/2025", "TESTE")

        dao.insertExpense(expense)

        val expenses = dao.getAllExpenses()

        assertEquals(expenses.size, 1)
        assertEquals(expenses[0], expense)

    }
    @After
    fun tearDown() {
        if(::database.isInitialized)
            database.close()
    }
}