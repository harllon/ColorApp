package com.example.colorapp.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.colorapp.databinding.ActivityLoginBinding
import com.example.colorapp.fragments.dialogbox.registerFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.concurrent.timerTask

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private var i = 0
    private val colorVector = arrayListOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GREEN, Color.RED, Color.CYAN,Color.LTGRAY, Color.YELLOW, Color.MAGENTA, Color.GRAY)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser != null){
            reload()
        }

        login(auth)
        register()
        changeColorTitle()
    }

    private fun login(auth: FirebaseAuth){
        loginBinding.loginButton.setOnClickListener {
            if(loginBinding.emailET.text.isNullOrEmpty() || loginBinding.passwordEditText.text.isNullOrEmpty()){
                Toast.makeText(this, "Please, fill all the fields", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(loginBinding.emailET.text.toString(), loginBinding.passwordEditText.text.toString()).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Email or Password is wrong", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun changeColorTitle(){
        /*Timer().schedule(timerTask {
            i %= colorVector.size
            loginBinding.titleTextView.setTextColor(colorVector[i])
            i++  }, 5000)*/
        Timer().schedule(timerTask {
            i %= colorVector.size
            loginBinding.titleTextView.setTextColor(colorVector[i])
            i++
        }, 1000, 3000)
    }
    private fun reload(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun register(){
        loginBinding.registerButtonLogin.setOnClickListener {
            val dialog = registerFragment()
            dialog.show(supportFragmentManager, dialog.tag)
        }
    }
}