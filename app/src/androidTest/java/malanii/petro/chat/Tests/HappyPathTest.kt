package malanii.petro.chat.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.LoginScreen
import malanii.petro.chat.Screens.MainScreen
import malanii.petro.chat.Screens.NavigationMainScreen
import malanii.petro.chat.Screens.UserNavigationScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@LargeTest
@RunWith(AndroidJUnit4::class)
class HappyPathTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    val validLogin = "q@q.com"
    val validPassword = "123456"

    @Test
    fun happyPath() {

        val mainScreen = MainScreen()
        mainScreen.clickOnNavigationDrawer()

        val userMainScreen = NavigationMainScreen()
        userMainScreen.clickOnLoginBtn()

        val loginScreen = LoginScreen()
        loginScreen.enter(validLogin, validPassword)
        loginScreen.tapOnLoginBtn()
        sleep(2000)

        val userNavigationScreen = UserNavigationScreen()
        userNavigationScreen.userInfoIsDisplayed

    }
}