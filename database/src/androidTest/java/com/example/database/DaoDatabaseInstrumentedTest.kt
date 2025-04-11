package com.example.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.database.dao.ExpenseDao
import com.example.database.entity.ExpenseLocal
import com.example.database.mapper.ExpenseMapper
import com.example.domain.model.Expense
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
        //local data source already define the conversion from domain to local
        val expense : ExpenseLocal =
            ExpenseMapper.toExpenseLocal(
                Expense(
                    1, "Food",
                100.0, "27/03/2025", "TESTE"))

        dao.insertExpense(expense)

        val expenses = dao.getAllExpenses()

        assertEquals(expenses.size, 1)
        assertEquals(expenses[0], ExpenseMapper.toExpense(expense))
    }

    @Test
    fun addExpense_should_not_insert_with_same_id(){
        val expense1 : ExpenseLocal =
            ExpenseMapper.toExpenseLocal(
                Expense(
                    1, "Food",
                    100.0, "27/03/2025", "TESTE"))

        val expense2 = ExpenseLocal(
            1, "teste", 100.0, "27/03/2025", "TESTE")

        dao.insertExpense(expense1)
        try{
            dao.insertExpense(expense2)
            fail("Esperava-se uma exceção de violação de chave primária ao inserir expense 2")
        }catch (e: Exception){
            assertTrue(e is android.database.sqlite.SQLiteConstraintException)
        }
    }
    @After
    fun tearDown() {
        if(::database.isInitialized)
            database.close()
    }
}