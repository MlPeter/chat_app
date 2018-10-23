package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import malanii.petro.chat.R
import org.hamcrest.Matchers

class MessagesScreen {

    private val messageField: ViewInteraction
        get() = onView(withId(R.id.messageTextField))

    private val sendMessageBtn: ViewInteraction
        get() = onView(withId(R.id.sendMessageBtn))

    fun enterMessage(){
        messageField.perform(replaceText("Hello"))
        Espresso.closeSoftKeyboard()
    }

    fun tapOnSendMessageBtn(){
        sendMessageBtn.perform(click())
    }

    val messageIsSent: ViewInteraction
        get() = onView(Matchers.allOf(withId(R.id.messageListView), ViewMatchers.withText("Hello")))
}