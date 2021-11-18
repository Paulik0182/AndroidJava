package com.android.androidandjava;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_second );

        backButton = findViewById ( R.id.back_button );

//        findViewById ( R.id.back_button ).setOnClickListener ( v -> {//еще одна версия обработки кнопки
//            finish ();
//        } );

        backButton.setOnClickListener ( v ->
                finish () //команда закрытия Activity. Она закроется как положено вызвав onPause, onStop, OnDestroy
        );
//          Ниже более длинная запись
//        backButton.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                finish ();
//            }
//        } );

    }
}