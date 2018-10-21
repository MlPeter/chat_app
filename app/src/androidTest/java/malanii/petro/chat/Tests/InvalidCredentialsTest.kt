package malanii.petro.chat.Tests

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.OpenNavigationDrawer
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)

class InvalidCredentialsTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun loginWithInvalidPswd(){
        val navDrawer = OpenNavigationDrawer()
        navDrawer.openNavigationDrawer()



    }











}