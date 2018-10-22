package malanii.petro.chat.Screens


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.withId
import malanii.petro.chat.R

class LoginScreen {

    private val emailField: ViewInteraction
        get() = onView(withId(R.id.loginEmailText))

    private val passwordField: ViewInteraction
        get() = onView(withId(R.id.loginPasswordText))

    private val loginBtn: ViewInteraction
        get() = onView(withId(R.id.loginLoginBtn))

    fun enter (email: String, password: String){
        emailField.perform(replaceText(email))
        passwordField.perform(replaceText(password), closeSoftKeyboard())
    }

    fun tapOnLoginBtn(){
        loginBtn.perform(click())
    }
}