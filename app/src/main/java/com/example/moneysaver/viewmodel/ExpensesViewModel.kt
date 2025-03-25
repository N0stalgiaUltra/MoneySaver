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

    // TODO: 1 - Adicionar Mocks antes de implementar a lógica no Room
    // TODO: 2 - Adicionar Injeção de Dependência
    // TODO: 3 - Implementar a Lógica basica correta com o uso do Room

    init {
        _expensesList.value = emptyList()
    }

    fun loadAllExpenses(){}
    fun addExpense(expense: Expense){
        if(!_expensesList.value!!.contains(expense)){
            mutableExpenses.add(expense)
            _expensesList.value = mutableExpenses.toList()
        }
    }
    fun deleteExpense(expense: Expense){}

}