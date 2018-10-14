package malanii.petro.chat.Controller


import android.support.test.espresso.DataInteraction
import android.support.test.espresso.ViewInteraction
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.*
import android.support.test.espresso.matcher.ViewMatchers.*

import malanii.petro.chat.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val appCompatImageButton = onView(
allOf(withContentDescription("Open navigation drawer"),
childAtPosition(
allOf(withId(R.id.toolbar),
childAtPosition(
withClassName(`is`("android.support.design.widget.AppBarLayout")),
0)),
1),
isDisplayed()))
        appCompatImageButton.perform(click())
        
        val appCompatButton = onView(
allOf(withId(R.id.loginBtnNavHeader), withText("Login"),
childAtPosition(
allOf(withId(R.id.nav_drawer_header_include),
childAtPosition(
withClassName(`is`("android.widget.RelativeLayout")),
0)),
3),
isDisplayed()))
        appCompatButton.perform(click())
        
        val appCompatButton2 = onView(
allOf(withId(R.id.loginCreateUserBtn), withText("Sign Up Here"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatButton2.perform(click())
        
        val appCompatImageView = onView(
allOf(withId(R.id.createAvatarImgView),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
4),
isDisplayed()))
        appCompatImageView.perform(click())
        
        val appCompatButton3 = onView(
allOf(withId(R.id.backgroundColorBtn), withText(" GENERATE BACKGROUND COLOR"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()))
        appCompatButton3.perform(click())
        
        val appCompatButton4 = onView(
allOf(withId(R.id.backgroundColorBtn), withText(" GENERATE BACKGROUND COLOR"),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
5),
isDisplayed()))
        appCompatButton4.perform(click())
        
        val button = onView(
allOf(withId(R.id.createUserBtn),
childAtPosition(
childAtPosition(
withId(android.R.id.content),
0),
6),
isDisplayed()))
        button.check(matches(isDisplayed()))
        }
    
    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
    }
