package com.sid.uitest.dialog

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.sid.uitest.R
import kotlinx.android.synthetic.main.activity_dialog.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogActivityTest{

    @Test
    fun testDialogNameInput() {
        // Given
        val activityScenario = ActivityScenario.launch(DialogActivity::class.java)
        val NAME = "Siddhartha"

        //Execute and verify
        onView(withId(R.id.button_launch_dialog)).perform(click())

        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        onView(withText(R.string.text_ok)).perform(click())

        // make sure dialog is still visible (can't click ok without entering a name)
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //enter a name
        onView(withId(R.id.md_input_message)).perform(typeText(NAME))

        onView(withText(R.string.text_ok)).perform(click())

        // make sure diaog is gone
        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        onView(withId(R.id.text_name)).check(matches(withText(NAME)))


    }
}