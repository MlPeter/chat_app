package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import malanii.petro.chat.Controller.App
import malanii.petro.chat.R

class UserMainScreen {

    private val loginLogoutBtn: ViewInteraction
        get() = onView(withId(R.id.loginBtnNavHeader))

    fun clickOnLoginBtn() {
        if (App.prefs.isLoggedIn) {
            loginLogoutBtn.perform(click())
            loginLogoutBtn.perform(click())
        } else {
            loginLogoutBtn.perform(click())
        }
    }

    fun clickOnLogoutBtn() {
        if (App.prefs.isLoggedIn) {
            loginLogoutBtn.perform(click())
        }else {
        }
    }
}