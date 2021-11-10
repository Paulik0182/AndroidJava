package com.android.androidandjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//это самый главный класc, с этого класса начинается собиратся приложение
public class MainActivity extends AppCompatActivity {

    //для того что-бы обратится к кнопке надо ее создать (создать переменную)
    private Button button1; //создали кнопку
    private Button buttonText; //создаем кнопку для изменения текста
    private EditText editText; //переменная поля для ввода текста
    private TextView textView; //переменная поля для отображения текста после нажатия кнопки
    private Button buttonOtherLayout; //переменная кнопки для перехода на другой экран (Activity)


    @Override
    protected void onCreate(Bundle savedInstanceState) { //здесь указываем сто нужно сделать при создании
        super.onCreate ( savedInstanceState ); // вызываем 1-й родительский модуль
        setContentView ( R.layout.activity_main ); // 2-й модуль

        //что бы воспользоватся кнопкой нужно ее поинециализировать
        button1 = findViewById ( R.id.button_1 ); //проинецализировали кнопку
        buttonText = findViewById ( R.id.button_text );//проинецализировали кнопку для изменения текста
        editText = findViewById ( R.id.edit_text_1 );//проинецализировали поле где вводится текст
        textView = findViewById ( R.id.result_edit_text_1 );//проинецализировали поле где выводится текст
        buttonOtherLayout = findViewById ( R.id.button_other_layout ); //проинецализировали кнопку перехода на другой экран

        //обращаемся к кнопке, установливаем слушатель нажатия
        button1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) { //нажатие, далее действие
                //делаем всплывающее сообщение в виде текста (выводим текст на экран
                Toast.makeText ( MainActivity.this, "меняем название кнопки", Toast.LENGTH_SHORT ).show ();
                button1.setText ( "Изменить" ); //меняем название кнопки
            }
        } );
        //с 38 по 45 строку можно упростить код, написать тоже самое, но короче
        //button1.setOnClickListener ( v -> button1.setText ( "Изменить" ) );

        buttonText.setOnClickListener ( new View.OnClickListener () { //устанавливаем слушатель
            @Override
            public void onClick(View v) { //нажимаем на кнопку
                //делаем всплывающее сообщение в виде текста (выводим текст на экран)
                Toast.makeText ( MainActivity.this, "преобразуем текст в другом поле", Toast.LENGTH_SHORT ).show ();
                String srcText = editText.getText ().toString ();// создаем переменную, присваеваем поле для ввода и приобразуем его в текст
                String result = srcText.toUpperCase ();// создаем переменную, присваеваем поле с результатом view преобразуем сам текст
                textView.setText ( result ); //вставляем результат в поле view
                Log.d ( "MainActivity", "увеличили текст " + srcText ); //сделали свой лог в данном классе. В данном случае лог можно посмотреть в Debug
            }
        } );

        buttonOtherLayout.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                startActivity ( intent );
            }
        } );
    }
}