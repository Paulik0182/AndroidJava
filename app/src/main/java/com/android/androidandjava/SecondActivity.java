package com.android.androidandjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView echoTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_second );

        backButton = findViewById ( R.id.back_button );
        echoTextView = findViewById ( R.id.echo_text_view );

        if (getIntent ().hasExtra ( MainActivity.MESSAGE_EXTRA_KEY )) {
            echoTextView.setText ( getIntent ().getStringExtra ( MainActivity.MESSAGE_EXTRA_KEY ) );
        }

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