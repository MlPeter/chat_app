package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import malanii.petro.chat.Controller.App

import malanii.petro.chat.R

class UserNavigationScreen : BaseScreen() {

    private val loginLogoutBtn: ViewInteraction
        get() = onView(withId(R.id.loginBtnNavHeader))

    private val userEmailI: ViewInteraction
        get() = onView(withId(R.id.userEmailNavHeader))

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

    fun tapOnLogoutBtn() {
        if (App.prefs.isLoggedIn) {
            loginLogoutBtn.perform(ViewActions.click())
        }else {
        }
    }
}