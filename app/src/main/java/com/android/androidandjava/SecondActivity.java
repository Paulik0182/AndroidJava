package com.android.androidandjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView echoTextView;
    private EditText messageEditText;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_second );

        backButton = findViewById ( R.id.back_button );
        messageEditText = findViewById ( R.id.message_edit_text );
        echoTextView = findViewById ( R.id.echo_text_view );

        if (getIntent ().hasExtra ( MainActivity.MESSAGE_EXTRA_KEY )) {
            echoTextView.setText ( getIntent ().getStringExtra ( MainActivity.MESSAGE_EXTRA_KEY ) );
        }

        findViewById ( R.id.back_button ).setOnClickListener ( v -> {//еще одна версия обработки кнопки
            String result = messageEditText.getText ().toString ();
            Intent resultIntent = new Intent ();//создаем интент с данными и кладем его в результат
            resultIntent.putExtra ( MainActivity.RESULT_EXTRA_KEY, result );
            setResult ( RESULT_OK, resultIntent );
            finish ();
        } );

//        backButton.setOnClickListener ( v ->
//                finish () //команда закрытия Activity. Она закроется как положено вызвав onPause, onStop, OnDestroy
//        );
//          Ниже более длинная запись
//        backButton.setOnClickListener ( new View.OnClickListener () {
//            @Override
//            public void onClick(View v) {
//                finish ();
//            }
//        } );

    }
}