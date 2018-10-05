package malanii.petro.chat.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import malanii.petro.chat.R
import malanii.petro.chat.Services.AuthService
import malanii.petro.chat.Services.UserDataService
import java.util.*

class CreateUserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[0.5, 0.5, 0.5, 1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
    }

    fun generateUserAvatar(view: View){
        val random = Random()
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if (color == 0){
            userAvatar = "ligth$avatar"
        }else {
            userAvatar = "dark$avatar"
        }
        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImgView.setImageResource(resourceId)

    }

    fun generateColorClicked(view: View){
        val random = Random()
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImgView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble() / 255
        val savedG = g.toDouble() / 255
        val savedB = b.toDouble() / 255

        avatarColor = "[$savedR, $savedG, $savedB, 1]"

    }

    fun createUserClicked(view: View){
        val userName = createUserNameTx.text.toString()
        val email = createEmailTx.text.toString()
        val password = createPasswordTx.text.toString()

        AuthService.registerUser(this, email, password) {registerSuccess ->
            if (registerSuccess){
                AuthService.loginUser(this, email, password) {loginSuccess ->
                    if (loginSuccess){
                       AuthService.createUser(this, userName, email, userAvatar, avatarColor){createSuccess ->
                           if (createSuccess){
                               println(UserDataService.avatarName)
                               println(UserDataService.avatarColor)
                               println(UserDataService.name)
                               finish()
                           }
                       }
                    }
                }
            }
        }
    }
}