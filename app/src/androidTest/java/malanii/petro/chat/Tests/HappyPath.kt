package malanii.petro.chat.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.LoginActivity
import malanii.petro.chat.Screens.OpenNavigationDrawer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HappyPath {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


@Test
    fun happyPath(){
    val validLogin = "q@q.com"
    val validPassword = "123456"

    val navDrawer = OpenNavigationDrawer()
    navDrawer.openNavigationDrawer()

    val login = LoginActivity()
    login.login(validLogin,validPassword)

}
}