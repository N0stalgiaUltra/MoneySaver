package com.example.moneysaver.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.entity.Expense

class ExpensesViewModel(): ViewModel() {

    private val _expensesList = MutableLiveData<List<Expense>>()
    val expensesList: LiveData<List<Expense>> = _expensesList

    // TODO: 1 - Adicionar Mocks antes de implementar a lógica no Room
    // TODO: 2 - Adicionar Injeção de Dependência
    // TODO: 3 - Implementar a Lógica basica correta com o uso do Room


    fun loadAllExpenses(){}
    fun addExpense(expense: Expense){}
    fun deleteExpense(expense: Expense){}

}