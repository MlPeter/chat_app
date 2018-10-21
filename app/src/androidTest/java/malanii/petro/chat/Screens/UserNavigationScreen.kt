package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId

import malanii.petro.chat.R

class UserNavigationScreen {

    private val userEmailI: ViewInteraction
        get() = onView(withId(R.id.userEmailNavHeader))

    val userInfoIsDisplayed: ViewInteraction
        get() = userEmailI.check(matches(isDisplayed()))
}