package malanii.petro.chat.Screens


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import malanii.petro.chat.R

class CreateUserScreen : BaseScreen(){

    private val userNameField: ViewInteraction
        get() = onView(withId(R.id.createUserNameTx))

    private val emailField: ViewInteraction
        get() = onView(withId(R.id.createEmailTx))

    private val passwordField: ViewInteraction
        get() = onView(withId(R.id.createPasswordTx))

    private val generateUserAvatarBtn: ViewInteraction
        get() = onView(withId(R.id.createAvatarImgView))

    private val createBackgroundColorBtn: ViewInteraction
        get() = onView(withId(R.id.backgroundColorBtn))

    private val createUserBtn: ViewInteraction
        get() = onView(withId(R.id.createUserBtn))

    override val uniqueView: ViewInteraction
        get() = createUserBtn

    init {
        uniqueView.check(matches(isDisplayed()))
    }

    fun enterNewUser(userName: String, email: String, password: String){
        userNameField.perform(replaceText(userName))
        emailField.perform(replaceText(email))
        passwordField.perform(replaceText(password))
    }

    fun tapOnGenerateUserAvatarBtn(){
        generateUserAvatarBtn.perform(click())
    }

    fun tapOnGenerateBackgroundColorBtn(){
        createBackgroundColorBtn.perform(click())
    }

    fun tapOnCreateUserBtn(){
        createUserBtn.perform(click())
    }
}