package com.example.moneysaver

import android.app.Activity
import android.database.sqlite.SQLiteConstraintException
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.PerformException
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moneysaver.fragments.AddExpense
import com.example.moneysaver.utils.ValidationResult
import com.example.moneysaver.utils.ValidationUtil
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddExpenseInstrumentedTest {


    @Test
    fun shouldDisplayAddNameTextField(){
        launchFragmentInContainer<AddExpense>(
            themeResId = R.style.Theme_MoneySaver)

        onView(withId(R.id.et_name))
            .check(matches(isDisplayed()))
    }

    @Test
    fun shouldNotAddItemIfNameIsEmpty(){
        launchFragmentInContainer<AddExpense>(
            themeResId = R.style.Theme_MoneySaver)

        val onViewEditText = onView(withId(R.id.et_name))

        onViewEditText.check(matches(isDisplayed()))
        onViewEditText.perform(typeText(""))

        val addButton = onView(withId(R.id.btn_add_expense))
        addButton.check(matches(isDisplayed())).perform(click())

        val result = ValidationUtil().validateName("")
        assertEquals(result.success, false)
    }


}