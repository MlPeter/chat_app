package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import malanii.petro.chat.R
import org.hamcrest.Matchers

class OpenNavigationDrawer {


    private val openNavDrawer = Espresso.onView(
            Matchers.allOf(
                    ViewMatchers.withContentDescription("Open navigation drawer"),
                    ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.toolbar))
            )
    )
    fun openNavigationDrawer(){
        openNavDrawer.perform(click())
    }
}