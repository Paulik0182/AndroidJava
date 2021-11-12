package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "@@@ SecondActivity"; //@@@ пометка по каторой будем искать, далее файл в который будем писать
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_second );

        SuperCounter counter = getIntent ().getExtras ().getParcelable ( MainActivity.COUNTER_KEY ); // передаем данные потаму что implements Parcelable
//        counter = getIntent ().getExtras ().getInt ( MainActivity.COUNTER_KEY );

//        if (MainActivity.COUNTER_KEY != null) {//запись не верная. Нужно проверить не является ли приходящее значение нулевым
//            counter = getIntent ().getExtras ().getInt ( MainActivity.COUNTER_KEY );//дастали значение из класса MainActivity
//        } else {
//            counter = 9;
//        }

        ((TextView) findViewById ( R.id.second_text_view )).setText ( String.valueOf ( counter.getCounter () ) );//положили значение в текст
//        ((TextView) findViewById ( R.id.second_text_view )).setText ( String.valueOf ( counter ) );//положили значение в текст

        Log.d ( TAG, "onCreate" );
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