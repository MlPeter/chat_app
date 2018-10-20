package malanii.petro.chat

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import malanii.petro.chat.Controller.MainActivity
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test

@Rule
@JvmField
var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

class allTests {

    val validLogin = "q@q.com"
    val validPassword = "123456"

@Test
    fun happyPath(){

    val openNavDrawer = onView(
            allOf(
                    isDescendantOfA(withId(R.id.toolbar)),
                    withContentDescription("Open navigation drawer")
            )
    )
    openNavDrawer.perform(click())


}




}