package com.example.moneysaver

import android.widget.DatePicker
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moneysaver.fragments.AddExpenseFragment
import com.example.moneysaver.utils.ValidationUtil
import junit.framework.TestCase.assertEquals
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddExpenseFragmentInstrumentedTest {

    /**
     *  Name Input Text
     * */
    @Test
    fun shouldDisplayAddNameTextField(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        onView(withId(R.id.et_name))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldNotAddItemIfNameIsEmpty(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(""))

        closeSoftKeyboard()
        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("")
        assertEquals(result.success, false)
    }

    @Test
    fun shouldNotAddItemIfNameIsTooLong(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
        closeSoftKeyboard()

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        assertEquals(result.success, false)
    }

    @Test
    fun shouldNotAddItemIfNameContainsNumbers(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(
            "nam0e"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("nam0e")
        assertEquals(result.success, false)
        assertEquals(result.error!![0], "Name cannot contain numbers !")
    }
    @Test
    fun shouldNotAddItemIfNameContainsSpecialCharacters(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(
            "n@me"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("n@me")
        assertEquals(result.success, false)
        assertEquals(result.error!![0], "Name cannot contain special characters !")

    }

    @Test
    fun shouldNotAddItemIfNameContainsSpecialCharactersNumbersOrTooLengthy(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(
            "n@0meaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("n@0meaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        assertEquals(result.success, false)

        val expectedErrors = listOf(
            "Name cannot contain special characters!",
            "Name cannot contain numbers!",
            "Name must be between 3 and 30 characters!"
        )

        expectedErrors.forEach { error ->
            assert(result.error!!.contains(error)){
                "expected error message not found: $error"
            }
        }

    }



    @Test
    fun shouldAcceptName(){
        launchFragmentInContainer<AddExpenseFragment>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText("Name"))

        closeSoftKeyboard()
        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("Name")
        assertEquals(result.success, true)
    }
    /**
     *  Amount Input Text
     * */

    @Test
    fun shouldDisplayAmountTextInput(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val amountEditText = onView(withId(R.id.et_amount))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldGetErrorIfAmountIsEqualToZero(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val amountEditText = onView(withId(R.id.et_amount))
            .check(matches(isDisplayed()))

        amountEditText.check(matches(isDisplayed()))
        amountEditText.perform(typeText(
            "0.0"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateAmount("0.0")
        assertEquals(result.success, false)
        assertEquals(result.error!![0], "Amount cannot be equals to zero !")
    }

    @Test
    fun shouldGetErrorIfAmountIsLessThanZero(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val amountEditText = onView(withId(R.id.et_amount))
            .check(matches(isDisplayed()))

        amountEditText.check(matches(isDisplayed()))
        amountEditText.perform(typeText(
            "-1.0"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateAmount("-1.0")
        assertEquals(result.success, false)
        assertEquals(result.error!![0], "Amount cannot be negative !")
    }

    @Test
    fun shouldAcceptDoubleEvenWithoutDecimal(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val amountEditText = onView(withId(R.id.et_amount))
            .check(matches(isDisplayed()))

        amountEditText.check(matches(isDisplayed()))
        amountEditText.perform(typeText(
            "10"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateAmount("10")
        assertEquals(result.success, true)
    }

    @Test
    fun shouldAcceptAmountWithDecimal(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val amountEditText = onView(withId(R.id.et_amount))
            .check(matches(isDisplayed()))

        amountEditText.check(matches(isDisplayed()))
        amountEditText.perform(typeText(
            "10.50"))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateAmount("10.50")
        assertEquals(result.success, true)
    }

    /**
     *  Date Picker
     * */

    @Test
    fun shouldNotAcceptEmptyDate(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val datePicker = onView(withId(R.id.et_date))
        datePicker.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateDate("")
        assertEquals(result.success, false)
        assertEquals(result.error!![0], "Date cannot be empty !")
    }

    @Test
    fun shouldAcceptDate(){
        launchFragmentInContainer<AddExpenseFragment>(themeResId = R.style.Theme_MoneySaver)

        val datePicker = onView(withId(R.id.et_date))
        datePicker.check(matches(isDisplayed())).perform(click())

        onView(withClassName(equalTo(DatePicker::class.java.name)))
            .perform(PickerActions.setDate(2005, 5, 14))

        val result = ValidationUtil().validateDate("14/5/2005")
        assertEquals(result.success, true)
    }

    /**
     *  Category Edit Text
     * */



}