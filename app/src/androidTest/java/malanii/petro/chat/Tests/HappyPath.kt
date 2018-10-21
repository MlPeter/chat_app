package malanii.petro.chat.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.App
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.MainScreen
import malanii.petro.chat.Screens.UserMainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HappyPath {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    val validLogin = "q@q.com"
    val validPassword = "123456"

    @Test
    fun happyPath() {

        val mainScreen = MainScreen()
        mainScreen.clickOnNavigationDrawer()

        val userMainScreen = UserMainScreen()
        userMainScreen.clickOnLogoutBtn()






    }
}