package com.example.moneysaver.utils

class ValidationUtil{
    fun validateName(name: String): ValidationResult{
        return if(name.isEmpty()) {
            ValidationResult(
                false,
                error = listOf("Name cannot be empty !")
            )
        }else if(name.length < 3 || name.length >= 30){
            ValidationResult(
                false,
                error = listOf("Name must be between 3 and 30 characters !")
            )
        }else{
            ValidationResult(true)
        }
    }
}

data class ValidationResult(
    val success: Boolean,
    val error: List<String>? = null
)