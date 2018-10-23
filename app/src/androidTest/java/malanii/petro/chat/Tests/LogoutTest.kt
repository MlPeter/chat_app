package malanii.petro.chat.Tests

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.UserNavigationScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogoutTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun logout(){

        val login = HappyPathTest()
        login.happyPath()

        val userNavigationScreen = UserNavigationScreen()
        userNavigationScreen.tapOnLogoutBtn()
        userNavigationScreen.userIsLogout
    }
}

