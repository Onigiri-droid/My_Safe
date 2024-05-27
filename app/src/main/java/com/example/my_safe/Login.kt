package com.example.my_safe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern.compile

class Login : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

    }

    val pattern = "[a-zA-Z0-9]{1,100}" +
            "\\@" +
            "[a-zA-Z]{1,15}" +
            "\\." +
            "[a-zA-Z]{1,10}"

    fun emailValid(email:String):Boolean{ return compile(pattern).matcher(email).matches()}

    fun login(view: View) {
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()){
            if (emailValid(email = email.text.toString())){
            val intent = Intent (this,MenuActivity::class.java)
            startActivity(intent)
            }
            else{
                val alert =AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Некорректное поле email")
                    .setPositiveButton("OK",null)
                    .create()
                    .show()
            }
        }
        else {
            val alert =AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
    }
}