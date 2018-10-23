package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import malanii.petro.chat.Controller.App

import malanii.petro.chat.R
import org.hamcrest.Matchers.allOf

class UserNavigationScreen : BaseScreen() {

    private val loginLogoutBtn: ViewInteraction
        get() = onView(withId(R.id.loginBtnNavHeader))

    private val userEmailI: ViewInteraction
        get() = onView(withId(R.id.userEmailNavHeader))

    val channelIsAdded: ViewInteraction
        get() = onView(allOf(withId(R.id.channel_list), withText("TEST!")))

    private val addChannelBtn: ViewInteraction
        get() = onView(withId(R.id.addChannelBtn))

    val userInfoIsDisplayed: ViewInteraction
        get() = userEmailI.check(matches(isDisplayed()))

    override val uniqueView: ViewInteraction
        get() = loginLogoutBtn

    init {
        uniqueView.check(matches(isDisplayed()))
    }

    fun clickOnLoginBtn() {
        if (App.prefs.isLoggedIn) {
            loginLogoutBtn.perform(ViewActions.click())
            loginLogoutBtn.perform(ViewActions.click())
        } else {
            loginLogoutBtn.perform(ViewActions.click())
        }
    }

    fun clickOnAddChannelBtn() {
        addChannelBtn.perform(click())
    }

    fun tapOnLogoutBtn() {
        if (App.prefs.isLoggedIn) {
            loginLogoutBtn.perform(ViewActions.click())
        }else {
        }
    }
}