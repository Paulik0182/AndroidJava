package com.android.androidandjava

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.androidandjava.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // lateinit - это отложенная инициализация. binding инициализируем в метоже onCreate
    private lateinit var binding: ActivityMainBinding

    private var view: View? = null //вопросик говорит о том, что переменная может быть нулевой
    //далее по коду, переменная должно быть везде с вопросиком, это значит, что код будет выполнятся если переменная не нуль.
    //таким образом мы защищаемся от исключения null pointer exception
    // знак ? своего рода проверка, если не нуль то код выполняется

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}