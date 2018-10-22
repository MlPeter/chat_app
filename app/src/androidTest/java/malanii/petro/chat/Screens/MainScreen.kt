package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed



import malanii.petro.chat.R
import org.hamcrest.Matchers


class MainScreen : BaseScreen(){

   private val openNavigationDrawerBtn: ViewInteraction
        get() = Espresso.onView(
                Matchers.allOf(
                        ViewMatchers.withContentDescription("Open navigation drawer"),
                        ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.toolbar))
                )
        )

    override val uniqueView: ViewInteraction
        get() = openNavigationDrawerBtn

    init {
        uniqueView.check(matches(isDisplayed()))
    }

    fun clickOnNavigationDrawer(){
        openNavigationDrawerBtn.perform(click())
    }
}