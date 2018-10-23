package malanii.petro.chat.Tests

import android.support.test.espresso.Espresso
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.R
import malanii.petro.chat.Screens.AddChannelScreen
import malanii.petro.chat.Screens.UserNavigationScreen
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CreateChannelTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    private val channelName = "TEST!"
    private val channelDescription = "Testing"
    private val channelIsAdded: ViewInteraction
        get() = Espresso.onView(Matchers.allOf(withId(R.id.channel_list), ViewMatchers.withText("TEST!")))


    @Test
    fun createNewChannelTest() {

        val login = HappyPathTest()
        login.happyPath()

        val userNavigationScreen = UserNavigationScreen()
        userNavigationScreen.clickOnAddChannelBtn()

        val addChannelScreen = AddChannelScreen()
        addChannelScreen.enterChannelInformation(channelName, channelDescription)
        addChannelScreen.tapOnAddChannelBtn()

        userNavigationScreen.channelIsAdded
    }
}

