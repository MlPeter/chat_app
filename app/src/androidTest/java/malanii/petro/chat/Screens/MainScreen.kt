package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import malanii.petro.chat.R
import org.hamcrest.Matchers


class MainScreen {

   private val openNavigationDrawerBtn: ViewInteraction
        get() = Espresso.onView(
                Matchers.allOf(
                        ViewMatchers.withContentDescription("Open navigation drawer"),
                        ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.toolbar))
                )
        )

    fun clickOnNavigationDrawer(){
        openNavigationDrawerBtn.perform(click())
    }
}