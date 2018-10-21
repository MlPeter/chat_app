package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers
import malanii.petro.chat.Controller.App
import malanii.petro.chat.R

class LoginActivity {

   private val validLogin = "q@q.com"
   private val validPassword = "123456"

    private fun logout(){
        onView(ViewMatchers.withId(R.id.loginBtnNavHeader))
                .perform(ViewActions.click())
    }

    fun login(email:String, password:String ) {


        if (App.prefs.isLoggedIn) {
            Espresso.onView(ViewMatchers.withId(R.id.loginBtnNavHeader))
                    .perform(ViewActions.click())
            Espresso.onView(ViewMatchers.withId(R.id.loginBtnNavHeader))
                    .perform(ViewActions.click())
            Espresso.onView(ViewMatchers.withId(R.id.loginEmailText))
                    .perform(ViewActions.replaceText(email))
            Espresso.onView(ViewMatchers.withId(R.id.loginPasswordText))
                    .perform(ViewActions.replaceText(password))
            Espresso.onView(ViewMatchers.withId(R.id.loginLoginBtn))
                    .perform(ViewActions.click())
            Thread.sleep(2000)
            logout()

        } else {
            Espresso.onView(ViewMatchers.withId(R.id.loginBtnNavHeader))
                    .perform(ViewActions.click())
            Espresso.onView(ViewMatchers.withId(R.id.loginEmailText))
                    .perform(ViewActions.replaceText(email))
            Espresso.onView(ViewMatchers.withId(R.id.loginPasswordText))
                    .perform(ViewActions.replaceText(password))
            Espresso.onView(ViewMatchers.withId(R.id.loginLoginBtn))
                    .perform(ViewActions.click())
            Thread.sleep(2000)
            logout()
        }
    }
}