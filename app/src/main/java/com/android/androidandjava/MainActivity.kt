package com.android.androidandjava

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.androidandjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding //генирируется автоматически binding для всех элементов view

//    //    private lateinit var loginButton: Button
//    private val loginButton: Button by lazy { findViewById(R.id.login_button) }//вариант записи. инициализировали сразу
//    //by lazy - это линивая инициализация. lazy инициализирует первый раз до тех пор пока вы чтото не сделаете с данной переменной,
//    // например, вызовите setOnClickListener. lazy обязательно должна быть val, поэтому во фрагменте мы уже ничего не сделаем,
//    // это можно сделать только в активити.
//    //lazy обычно используют для обращения к репозеториям.
//
//    private lateinit var emailEditText: EditText
//    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater)// layoutInflater - это системный сервис андройд
        // который можно получать через контекст. это для раздувания разметки (xml файла)
        setContentView(binding.root)

        //apply - это экстейшен, это способ передать binding. нет необходимости везде писать binding
        binding.apply {
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
                Toast.makeText(baseContext, toastMassage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun checkCredentials(email: String, password: String): Boolean {
            return email == password
        }
    }
}