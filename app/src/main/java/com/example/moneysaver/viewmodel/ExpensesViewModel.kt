package com.example.moneysaver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.Expense
import kotlin.math.exp

class ExpensesViewModel(): ViewModel() {

    private val _expensesList = MutableLiveData<List<Expense>>()
    val expensesList: LiveData<List<Expense>> = _expensesList

    //buffer
    private val mutableExpenses = mutableListOf<Expense>()

    // TODO: 2 - Adicionar Injeção de Dependência
    // TODO: 3 - Implementar a Lógica basica correta com o uso do Room

    init {
        _expensesList.value = emptyList()
    }

    fun loadAllExpenses(){

        // TODO: 1 - Recuperação tem que ocorrer com o Room

        val listExpenses = listOf(
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
        _expensesList.value = listExpenses
    }

    fun addExpense(expense: Expense){
        // TODO: 1 - Adicionar com UseCase
        // TODO: 2 - Adicionar no Room

        if(!mutableExpenses.contains(expense)){
            mutableExpenses.add(expense)
            _expensesList.value = mutableExpenses.toList()
        }
    }
    fun deleteExpense(expense: Expense){
        // TODO: 1 - Remover com UseCase
        // TODO: 2 - Remover no Room
        _expensesList.value = mutableExpenses.filter { it != expense }
        if(mutableExpenses.contains(expense))
            mutableExpenses.remove(expense)

    }



}