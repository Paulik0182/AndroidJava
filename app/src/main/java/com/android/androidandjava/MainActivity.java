package com.android.androidandjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_EXTRA_KEY = "message";
    public static final String RESULT_EXTRA_KEY = "result";

    private static final int ECHO_REQUEST_CODE = 1111;

    private TextView echoTextView;
    private EditText messageEditText;
    private Button nextButton;
    private Button sendButton;
    private Button dispatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        echoTextView = findViewById ( R.id.echo_text_view );
        messageEditText = findViewById ( R.id.message_edit_text );
        nextButton = findViewById ( R.id.next_button );
        sendButton = findViewById ( R.id.send_button );
        dispatchButton = findViewById ( R.id.dispatch_button );

        nextButton.setOnClickListener ( v -> {
            Intent intent = new Intent ( this, SecondActivity.class );//создали намерение
            intent.putExtra ( MESSAGE_EXTRA_KEY, messageEditText.getText ().toString () );//вложили через ключь значения для передачи их во вторую активити SecondActivity
            startActivityForResult ( intent, ECHO_REQUEST_CODE );// заявили что запускаем активити чтобы получить результат
//            this.startActivity ( intent );
        } );

        sendButton.setOnClickListener ( v -> {
//            Intent intent = new Intent (Intent.ACTION_VIEW, Uri.parse ("http://www.yandex.ru"));//нажатием на кнопку мы откроем браузер с помощью ссылки
            Intent intent = new Intent ();//Вариант 2 . переход по ссылке
            intent.setAction ( Intent.ACTION_VIEW );//Вариант 2 . переход по ссылке
            intent.setData ( Uri.parse ( "http://www.yandex.ru" ) );//Вариант 2 . переход по ссылке
            startActivity ( intent );
        } );

        dispatchButton.setOnClickListener ( v -> {
            String message = messageEditText.getText ().toString ();
            Intent intent = new Intent ();
            intent.setAction ( Intent.ACTION_SEND );
            intent.setType ( "plain/text" );
            intent.putExtra ( Intent.EXTRA_TEXT, message );
            startActivity ( intent );
        } );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//функция для того, чтобы вытинуть из второй активити сохнаненные там значения
        super.onActivityResult ( requestCode, resultCode, data );
        if (requestCode == ECHO_REQUEST_CODE && resultCode == RESULT_OK) { // проверили, что ECHO_REQUEST_CODE соответствует запуску конкретной активити. RESULT_OK о том что все хорошо
            if (data != null && data.hasExtra ( RESULT_EXTRA_KEY )) { //проверяем на то что данные которые пришли не равны null, и есть такой ключь RESULT_EXTRA_KEY
                String echoStr = data.getStringExtra ( RESULT_EXTRA_KEY );//получаем ключ
                echoTextView.setText ( echoStr );//и выводим его


            }
        }
    }
}