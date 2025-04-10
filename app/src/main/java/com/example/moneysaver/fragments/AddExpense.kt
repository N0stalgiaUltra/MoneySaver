package com.example.moneysaver.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.moneysaver.databinding.FragmentAddExpenseBinding
import com.example.moneysaver.utils.ValidationResult
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

        binding.etAmount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if(text.contains(".")){
                    val split = text.split(".")
                    if(split[1].length > 2){
                       val newText = "${split[0]}.${split[1].substring(0,2)}"
                        binding.etAmount.removeTextChangedListener(this)
                        binding.etAmount.setText(newText)
                        binding.etAmount.setSelection(newText.length)
                        binding.etAmount.addTextChangedListener(this)
                    }
                }
            }
        })

        binding.etDate.setOnClickListener {
            openDateDialog()
        }

        binding.btnAddExpense.setOnClickListener {
            validateFields()
        }
    }

    private fun openDateDialog() {
        val dialog = DatePickerDialog(requireContext(),{
             _, year, month, dayOfMonth -> binding.etDate.setText("$dayOfMonth/${month+1}/$year")
        } , 2025, 0, 15).show()
    }

    /**
     * Method to validate all the text input fields
     * */
    private fun validateFields(){
        val resultName = validationUtil.validateName(binding.etName.text.toString())
        if(!resultName.success)
            binding.etName.error = resultName.error.toString()
        else
            binding.etLayoutName.error = null

        val resultAmount = validationUtil.validateAmount(binding.etAmount.text.toString())
        if(!resultAmount.success)
            binding.etAmount.error = resultAmount.error.toString()
        else
            binding.etLayoutAmount.error = null

    }

}