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

@RunWith(AndroidJUnit4::class)
class CreateUserTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    val newEmail = "test@test.com"
    val newUserName = "test"
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
        sleep(2000)

        userNavigationScreen.userInfoIsDisplayed
    }
}