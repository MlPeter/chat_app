package malanii.petro.chat.Tests

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.LoginScreen
import malanii.petro.chat.Screens.MainScreen
import malanii.petro.chat.Screens.UserNavigationScreen
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep




@LargeTest
@RunWith(AndroidJUnit4::class)
class ErrorsTests {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    val validLogin = "q@q.com"
    val emptyLogin = ""
    val invalidPassword = "111111"
    val emptyPassword = ""

    @Test
    fun invalidEmailTest(){
        val mainScreen = MainScreen()
        mainScreen.clickOnNavigationDrawer()

        val userNavigationScreen = UserNavigationScreen()
        userNavigationScreen.clickOnLoginBtn()

        val loginScreen = LoginScreen()
        loginScreen.enter(validLogin, invalidPassword)
        loginScreen.tapOnLoginBtn()
        sleep(3500)
        onView(
                allOf(withContentDescription(
                        "Something went wrong, please try again"),
                        isDisplayed()))
    }

    @Test
    fun emptyEmailAndPasswordFieldsTest(){
        val mainScreen = MainScreen()
        mainScreen.clickOnNavigationDrawer()

        val userNavigationScreen = UserNavigationScreen()
        userNavigationScreen.clickOnLoginBtn()

        val loginScreen = LoginScreen()
        loginScreen.enter(emptyLogin, emptyPassword)
        loginScreen.tapOnLoginBtn()
        onView(
                allOf(withContentDescription(
                        "Please fill in both email and password"),
                        isDisplayed()))
    }
}