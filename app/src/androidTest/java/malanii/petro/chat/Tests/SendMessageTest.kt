package malanii.petro.chat.Tests

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import malanii.petro.chat.Controller.MainActivity
import malanii.petro.chat.Screens.MessagesScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(AndroidJUnit4::class)
class SendMessageTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun sendMessageTest(){

        val login = HappyPathTest()
        login.happyPath()

        val messageScreen = MessagesScreen()
        messageScreen.enterMessage()
        messageScreen.tapOnSendMessageBtn()
        sleep(1000)
        messageScreen.messageIsSent
        sleep(1000)
    }
}