package com.android.androidandjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//это самый главный клас, с этого класса начинается собиратся приложение
public class MainActivity extends AppCompatActivity {

    //для того что-бы обратится к кнопке надо ее создать (создать переменную)
    private Button button1; //создали кнопку
    private Button buttonText; //создаем кнопку для изменения текста
    private EditText editText; //переменная поля для ввода текста
    private TextView textView; //переменная поля для отображения текста после нажатия кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) { //здесь указываем сто нужно сделать при создании
        super.onCreate ( savedInstanceState ); // вызываем 1-й родительский модуль
        setContentView ( R.layout.activity_main ); // 2-й модуль

        //что бы воспользоватся кнопкой нужно ее поинециализировать
        button1 = findViewById ( R.id.button1 ); //проинецализировали кнопку
        buttonText = findViewById ( R.id.buttonText );//проинецализировали кнопку для изменения текста
        editText = findViewById ( R.id.editText1 );//проинецализировали поле где вводится текст
        textView = findViewById ( R.id.resultEditText1 );//проинецализировали поле где выводится текст

        //обращаемся к кнопке, установливаем слушатель нажатия
        button1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) { //нажатие, далее действие
                button1.setText ( "Изменить" ); //меняем название кнопки
            }
        } );
        //с 32 по 37 строку можно упростить код, написать тоже самое, но короче
        //button1.setOnClickListener ( v -> button1.setText ( "Изменить" ) );

        buttonText.setOnClickListener ( new View.OnClickListener () { //устанавливаем слушатель
            @Override
            public void onClick(View v) { //нажимаем на кнопку
                String srcText = editText.getText ().toString ();// создаем переменную, присваеваем поле для ввода и приобразуем его в текст
                String result = srcText.toUpperCase ();// создаем переменную, присваеваем поле с результатом view преобразуем сам текст
                textView.setText ( result ); //вставляем результат в поле view
                Log.d ( "MainActivity", "увеличили текст " + srcText ); //сделали свой лог в данном классе. В данном случае лог можно посмотреть в Debug
            }
        } );
    }
}