package com.android.androidandjava

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //    private lateinit var loginButton: Button
    private val loginButton: Button by lazy { findViewById(R.id.login_button) }//вариант записи. инициализировали сразу
    //by lazy - это линивая инициализация. lazy инициализирует первый раз до тех пор пока вы чтото не сделаете с данной переменной,
    // например, вызовите setOnClickListener. lazy обязательно должна быть val, поэтому во фрагменте мы уже ничего не сделаем,
    // это можно сделать только в активити.
    //lazy обычно используют для обращения к репозеториям.


    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        loginButton = findViewById(R.id.login_button)//вариант записи
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)

        loginButton.setOnClickListener {
            val toastMassage = if (checkCredentials(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
                )
            ) {
                "OK"
            } else {
                "ERROR"
            }
            Toast.makeText(this, toastMassage, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun checkCredentials(email: String, password: String): Boolean {
            return email == password
        }
    }

}