package com.sid.uitest.movieapp.ui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.sid.uitest.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieNavigationTest {

    @Test
    fun testMovieFragmentNavigation() {
        //SETUP
        val activityScenario = ActivityScenario.launch(MainActivityMovie::class.java)

        //NAV DirectorFragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //VERIFY
        onView(withId(R.id.fragment_directors_parent)).check(matches(isDisplayed()))

        //NAV to MovieDetail Fragment
        pressBack()

        // Verify
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))

        // Nav StarActorsFragment

        onView(withId(R.id.movie_star_actors)).perform(click())

        //Verify

        onView(withId(R.id.fragment_star_actors_parent)).check(matches(isDisplayed()))

        //Nav MovieDetail Frag
        pressBack()

        //Verify
        onView(withId(R.id.fragment_movie_detail_parent)).check(matches(isDisplayed()))

    }
}
