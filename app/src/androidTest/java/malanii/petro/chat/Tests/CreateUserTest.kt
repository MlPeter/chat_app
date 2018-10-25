package malanii.petro.chat.Tests

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.LoginScreen
import malanii.petro.chat.Screens.MainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep
import java.util.*

@RunWith(AndroidJUnit4::class)
class CreateUserTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    val random = Random().nextInt(70000-1)

    val newEmail = "test${random}@test.com"
    val newUserName = "test${random}"
    val newPassword = "123456"

    @Test
    fun createNewUserTest(){
        val mainScreen = MainScreen()
        val userNavigationScreen = mainScreen.clickOnNavigationDrawer()
        userNavigationScreen.clickOnLoginBtn()

        val loginScreen = LoginScreen()
        val createUserScreen = loginScreen.tapOnSignUoHereBtn()
        createUserScreen.enterNewUser(newUserName, newEmail, newPassword)
        createUserScreen.tapOnGenerateUserAvatarBtn()
        createUserScreen.tapOnGenerateBackgroundColorBtn()
        createUserScreen.tapOnCreateUserBtn()

        userNavigationScreen.userInfoIsDisplayed
    }
}