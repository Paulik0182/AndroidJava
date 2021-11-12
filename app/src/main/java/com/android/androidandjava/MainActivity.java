package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@@@ MainActivity"; //@@@ пометка по каторой будем искать, далее файл в который будем писать

    private TextView counterTextView;//переменная текстового поля
    private static final String COUNTER_KEY = "counter_key";
    //    private Integer counter = 0;//переменная счетчика и иницализация ее
    private int counter;//переменная счетчика

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        counterTextView = findViewById ( R.id.counter_text_view );//получаем доступ к строке
//        counterTextView.setText ( counter.toString () );//Вариант 1. обрабатываем результат, преобразуем в строку
//        counterTextView.setText ( String.valueOf ( counter ) );// Вариант 2.
//        counterTextView.setText ( String.format ( "Вы нажали %d раз", counter ) );//Вариант 3. преобразование в строку через формат

        if (savedInstanceState != null && savedInstanceState.containsKey ( "COUNTER_KEY" )) {//Проверяем то чтото есть на экране, не ровно нулю и проверяем наличее ключа
            counter = savedInstanceState.getInt ( "COUNTER_KEY" );// сохраняем по ключу
        } else {
            counter = 0;// иницализация переменной счетчика
        }
        updateCounterView ();

        findViewById ( R.id.button_activity2 ).setOnClickListener ( v -> { //обработка клика кнопки. открытие второй Активити
            Toast.makeText ( this, "перешли на второй экран", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( this, SecondActivity.class );
            startActivity ( intent );
            Log.d ( TAG, "Send Intent MainActivity -> SecondActivity" );//лог на вторую активити
        } );

        findViewById ( R.id.button_inc ).setOnClickListener ( v -> { //обработка клика кнопки. обработка текстовой строки
            counter++;
            Toast.makeText ( this, "Нажал", Toast.LENGTH_SHORT ).show ();
//            counterTextView.setText ( String.format ( "Вы нажали %d раз", counter ) );//Вариант 3.
            updateCounterView ();
        } );

        Log.d ( TAG, "onCreate" );
    }

    @SuppressLint("DefaultLocale")
    private void updateCounterView() {//  создали функцию которую будем вызывать при обработке кнопки и запуске активити
        counterTextView.setText ( String.format ( "Вы нажали %d раз", counter ) );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState ( savedInstanceState );
        Log.d ( TAG, "onRestoreInstanceState" );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt ( "COUNTER_KEY", counter ); //использование ключа при сохранении. это ключ.
        super.onSaveInstanceState ( outState );
        Log.d ( TAG, "onSaveInstanceState" );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        Log.d ( TAG, "onStart" );
    }

    @Override
    protected void onRestart() {
        super.onRestart ();
        Log.d ( TAG, "onRestart" );
    }

    @Override
    protected void onPause() {
        super.onPause ();
        Log.d ( TAG, "onPause" );
    }

    @Override
    protected void onStop() {
        super.onStop ();
        Log.d ( TAG, "onStop" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        Log.d ( TAG, "onDestroy" );
    }
}