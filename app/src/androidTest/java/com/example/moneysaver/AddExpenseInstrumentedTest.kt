package com.example.moneysaver

import android.app.Activity
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.moneysaver.fragments.AddExpense
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddExpenseInstrumentedTest {


    @Test
    fun shouldDisplayAddNameTextField(){

        launchFragmentInContainer<AddExpense>(
            themeResId = R.style.Theme_MoneySaver
        )

        onView(withId(R.id.et_name))
            .check(matches(isDisplayed()))
    }
}