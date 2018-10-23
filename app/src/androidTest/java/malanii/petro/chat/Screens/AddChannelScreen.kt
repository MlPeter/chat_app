package malanii.petro.chat.Screens

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import malanii.petro.chat.R
import org.hamcrest.Matchers.allOf

class AddChannelScreen : BaseScreen() {

    private val channelNameField: ViewInteraction
        get() = onView(withId(R.id.addChannelNameTxt))

    private val channelDescriptionField: ViewInteraction
        get() = onView(withId(R.id.addChannelDescTxt))

    private val addBtn: ViewInteraction
        get() = onView(allOf(withId(android.R.id.button1)))

    override val uniqueView: ViewInteraction
        get() = channelNameField

    init {
        uniqueView.check(matches(isDisplayed()))
    }

    fun enterChannelInformation(channelName: String, channelDescription: String){
        channelNameField.perform(replaceText(channelName))
        channelDescriptionField.perform(replaceText(channelDescription))
    }

    fun tapOnAddChannelBtn(){
        addBtn.perform(click())
    }
}