package com.example.moneysaver.utils

class ValidationUtil{
    fun validateName(name: String): ValidationResult{
        val errors = mutableListOf<String>()

        if (name.isEmpty()) {
            errors.add("Name cannot be empty!")
        }
        if (!validateStringLenght(name, 3, 30)) {
            errors.add("Name must be between 3 and 30 characters!")
        }
        if (validateNoNumbers(name)) {
            errors.add("Name cannot contain numbers!")
        }
        if (validateNoSpecialChars(name)) {
            errors.add("Name cannot contain special characters!")
        }

        return if (errors.isEmpty()) {
            ValidationResult(true)
        } else {
            ValidationResult(false, error = errors)
        }
    }

    fun validateAmount(amount: String): ValidationResult{
        return if(amount.isEmpty()){
            ValidationResult(
                false,
                error = listOf("Amount cannot be empty !")
            )
        }
        else if(amount.toDouble() < 0.0){
            ValidationResult(
                false,
                error = listOf("Amount cannot be negative !")
            )
        }
        else if (amount.toDouble() == 0.0){
            ValidationResult(
                false,
                error = listOf("Amount cannot be equals to zero !")
            )
        }
        else
            ValidationResult(true)
    }

    fun validateDate(date: String): ValidationResult{
        return if(date.isEmpty())
            ValidationResult(
                false,
                error = listOf("Date cannot be empty !")
            ) else
                ValidationResult(true)
    }

    fun validateCategory(category: String): ValidationResult{
        return if(category.isEmpty())
            ValidationResult(
                false,
                error = listOf("Category cannot be empty !")
            ) else if(!validateStringLenght(category, 3, 30)){
                ValidationResult(
                    false,
                    error = listOf("Category must be between 3 and 30 characters !")
                )
            } else if(validateNoNumbers(category)){
                ValidationResult(
                    false,
                    error = listOf("Category cannot contain numbers !")
                )
            }
            else
                ValidationResult(true)

    }

    private fun validateStringLenght(value: String, min: Int, max: Int): Boolean{
        return value.length in min..max
    }

    private fun validateNoSpecialChars(value: String): Boolean{
        return Regex("[^a-zA-Z0-9 ]").containsMatchIn(value)
    }

    private fun validateNoNumbers(value: String): Boolean{
        return Regex("\\d").containsMatchIn(value)
    }


}

data class ValidationResult(
    val success: Boolean,
    val error: List<String>? = null
)