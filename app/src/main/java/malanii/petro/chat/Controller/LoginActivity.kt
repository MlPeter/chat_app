package malanii.petro.chat.Controller

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.test.espresso.IdlingRegistry
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import malanii.petro.chat.R
import malanii.petro.chat.Services.AuthService

class LoginActivity : AppCompatActivity() {

    val idling = AuthService.countingIdlingResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginSpinner.visibility = View.INVISIBLE
    }

    fun loginLoginBtnClicked(view: View){
        enableSpinner(true)
        val email = loginEmailText.text.toString()
        val password = loginPasswordText.text.toString()
        hideKeyboard()

        if (email.isNotEmpty() && password.isNotEmpty()){
            IdlingRegistry.getInstance().register(idling)
            AuthService.loginUser(email, password) {loginSuccess ->
                if (loginSuccess){
                    AuthService.findUserByEmail(this) {findSuccess ->
                        if (findSuccess) {
                            IdlingRegistry.getInstance().unregister(idling)
                            enableSpinner(false)
                            finish()
                        } else {
                            IdlingRegistry.getInstance().unregister(idling)
                            errorToast()
                        }
                    }
                } else {
                    IdlingRegistry.getInstance().unregister(idling)
                    errorToast()
                }
            }
        } else {
            Toast.makeText(this, "Please fill in both email and password", Toast.LENGTH_LONG).show()
        }
    }

    fun loginCreateUserBtnClicked(view: View){
        val createUserIntent = Intent(this, CreateUserActivity::class.java)
        startActivity(createUserIntent)
        finish()
    }

    fun errorToast() {
        Toast.makeText(this, "Something went wrong, please try again",
                Toast.LENGTH_LONG).show()
        enableSpinner(false)
    }

    fun enableSpinner(enable: Boolean){
        if (enable) {
            loginSpinner.visibility = View.VISIBLE
        }else {
            loginSpinner.visibility = View.INVISIBLE
        }
        loginLoginBtn.isEnabled = !enable
        loginCreateUserBtn.isEnabled = !enable
    }

    fun hideKeyboard() {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if (inputManager.isAcceptingText) {
            inputManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        }
    }
}
