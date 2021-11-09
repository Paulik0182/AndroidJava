package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//это класс второго Activity
public class SecondActivity extends AppCompatActivity {

    //для того что-бы обратится к кнопке надо ее создать (создать переменную)
    private Button buttonSecondText; //создаем кнопку для изменения текста
    private EditText editText2; //переменная поля для ввода текста
    private TextView textView2; //переменная поля для отображения текста после нажатия кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) { //здесь указываем сто нужно сделать при создании
        super.onCreate ( savedInstanceState ); // вызываем 1-й родительский модуль
        setContentView ( R.layout.activity_second ); // 2-й модуль

        //что бы воспользоватся кнопкой нужно ее поинециализировать
        buttonSecondText = findViewById ( R.id.buttonText2 );//проинецализировали кнопку для изменения текста
        editText2 = findViewById ( R.id.editText2 );//проинецализировали поле где вводится текст
        textView2 = findViewById ( R.id.resultEditText2 );//проинецализировали поле где выводится текст

        buttonSecondText.setOnClickListener ( new View.OnClickListener () { //устанавливаем слушатель
            @Override
            public void onClick(View v) { //нажимаем на кнопку
                //делаем всплывающее сообщение в виде текста (выводим текст на экран
                Toast.makeText ( SecondActivity.this, "преобразуем текст в другом поле на втором экране", Toast.LENGTH_SHORT ).show ();
                String srcText2 = editText2.getText ().toString ();// создаем переменную, присваеваем поле для ввода и приобразуем его в текст
                String result2 = srcText2.toUpperCase ();// создаем переменную, присваеваем поле с результатом view преобразуем сам текст
                textView2.setText ( result2 ); //вставляем результат в поле view
                Log.d ( "MainActivity", "увеличили текст " + srcText2 ); //сделали свой лог в данном классе. В данном случае лог можно посмотреть в Debug
            }
        } );
    }
}