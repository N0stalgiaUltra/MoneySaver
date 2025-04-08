package com.example.moneysaver.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moneysaver.databinding.FragmentAddExpenseBinding
import com.example.moneysaver.utils.ValidationUtil


class AddExpense : Fragment() {

    private lateinit var binding: FragmentAddExpenseBinding
    private val validationUtil = ValidationUtil()
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
            val name = binding.etName.text.toString()
            val result = validationUtil.validateName(name)
            // TODO: criar dialogo exibindo erro 
//            if(nome.trim().isEmpty())
//                throw IllegalArgumentException("Name cannot be empty")
        }
    }


    private fun validateFields(){}

}