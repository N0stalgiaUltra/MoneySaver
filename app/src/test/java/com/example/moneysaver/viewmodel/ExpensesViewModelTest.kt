package com.example.moneysaver.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.entity.Expense
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test

class ExpensesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ExpensesViewModel
    /**
     * 1- Mockar a viewModel
     * 2- Mockar uma lista de expenses/despesas
     * 3- Mockar um expense/despesa
     * 4- Casos de teste
     */

    @Before
    fun setUp() {
        viewModel = ExpensesViewModel()
    }


    @Test
    fun `given a new view model, should provide an initial empty list state`(){
        val actualList = viewModel.expensesList.value
        assert(actualList.isNullOrEmpty())
    }

    //addExpenses tests
    @Test
    fun `when addExpense is called, the list should add the expense`(){
        assert(viewModel.expensesList.value.isNullOrEmpty())

        val expense = Expense(
            0,
            "Celular",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        viewModel.addExpense(expense)

        val actualList = viewModel.expensesList.value
        assertTrue(actualList!!.isNotEmpty())
        assertTrue(
            actualList.contains(expense)
        )
    }

    @Test
    fun `addExpense should not allow to insert the same Expense twice`(){
        val expense = Expense(
            0,
            "Celular",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )
        viewModel.addExpense(expense)

        val expenseCopy = Expense(
            0,
            "Celular",
            100.00,
            "03/02/1998",
            "Despesas",
            "Celular Novo"
        )

        viewModel.addExpense(expenseCopy)

        val expenseList = viewModel.expensesList.value
        assertTrue(expenseList!!.size == 1)
    }

    //loadAllExpenses tests - tem que ser adaptados com UseCase
//    @Test
//    fun `if list is empty, loadAllExpenses should return an empty list`(){
//        viewModel.loadAllExpenses()
//        val expenseList = viewModel.expensesList
//        assertTrue(expenseList.value.isNullOrEmpty())
//
//    }
//
    @Test
    fun `if list is not empty, loadAllExpenses should return the list`(){
        viewModel.loadAllExpenses()
        val expenseList = viewModel.expensesList
        assertTrue(expenseList.value!!.isNotEmpty())
    }

    @Test
    fun `if the list is empty, should not delete nothing`(){
        val emptyExpenseList = viewModel.expensesList.value
        assertTrue(emptyExpenseList!!.isEmpty())

        viewModel.deleteExpense(getExpensesList()[0])

        val expenseList = viewModel.expensesList.value
        assertTrue(expenseList!!.isEmpty())
    }

    @Test
    fun `if expense is not in the expense list, should not delete nothing`(){
        val expense = Expense(
            4,
            "Teste",
            100.00,
            "03/02/1998",
            "Teste",
            "Teste"
        )

        viewModel.deleteExpense(expense)

        //in this case, list is empty
        val expenseList = viewModel.expensesList.value
        assertTrue(expenseList!!.isEmpty())
        assertTrue(!expenseList.contains(expense))
    }

    @Test
    fun `if expense is in expense list, deleteExpenses should delete the expense`(){
        viewModel.loadAllExpenses()
        val expenseList = viewModel.expensesList
        val expense = expenseList.value!![0]

        viewModel.deleteExpense(expense)
        assertTrue(!expenseList.value!!.contains(expense))
    }
    //Mock do loadAllExpenses
    companion object{
        fun getExpensesList(): List<Expense>{
            return listOf(
                Expense(
                    0,
                    "Celular",
                    100.00,
                    "03/02/1998",
                    "Despesas",
                    "Celular Novo"
                ), Expense(
                    1,
                    "Chuteira",
                    500.00,
                    "03/02/2023",
                    "Custos Simples",
                    "Chuteira nova"
                ), Expense(
                    2,
                    "Plano de saude",
                    450.00,
                    "01/12/2005",
                    "Despesas",
                    "Plano de saude novo"
                ),
            )
        }
    }
}