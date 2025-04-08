package com.example.moneysaver.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneysaver.R
import com.example.moneysaver.databinding.FragmentAddExpenseBinding


class AddExpense : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddExpenseBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddExpense.setOnClickListener {
            val nome = binding.etName.text.toString()

            // TODO: Criar uma classe para validar se os edit texts estarão vazios 
            if(nome.trim().isEmpty())
                throw IllegalArgumentException("Name cannot be empty")
        }
    }
}