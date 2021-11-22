package com.android.androidandjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ECHO_PREF_KEY = "echo";

    public static final String MESSAGE_EXTRA_KEY = "message";
    public static final String RESULT_EXTRA_KEY = "result";
    public static final String PREF_NAME = "MainActivity.echo";
    private static final String TAG = "@@@MainActivity";

    private static final int ECHO_REQUEST_CODE = 1111;

    private TextView echoTextView;
    private EditText messageEditText;
    private Button nextButton;
    private Button sendButton;
    private Button dispatchButton;
    private Button dispatchWindButton;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        echoTextView = findViewById ( R.id.echo_text_view );
        messageEditText = findViewById ( R.id.message_edit_text );
        nextButton = findViewById ( R.id.next_button );
        sendButton = findViewById ( R.id.send_button );
        dispatchButton = findViewById ( R.id.dispatch_button );
        dispatchWindButton = findViewById ( R.id.dispatch_wind_button );
        calculateButton = findViewById ( R.id.calculate_button );

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
            intent.setType ( "plain/text" );//если закомитить эту строчку, то сработает проверка и выдаст сооющение toast
            intent.putExtra ( Intent.EXTRA_TEXT, message );
            if (intent.resolveActivity ( getPackageManager () ) != null) {// проверяем есть ли приложение для его вызова. делать всегда
                startActivity ( intent );
            } else {
                Toast.makeText ( this, "No Activity", Toast.LENGTH_SHORT ).show ();
            }
        } );

        dispatchWindButton.setOnClickListener ( v -> {
            String message = messageEditText.getText ().toString ();
            Intent intent = new Intent ();
            intent.setAction ( Intent.ACTION_SEND );
            intent.setType ( "plain/text" );//если закомитить эту строчку, то сработает проверка и выдаст сооющение toast
            intent.putExtra ( Intent.EXTRA_TEXT, message );
            if (intent.resolveActivity ( getPackageManager () ) != null) {// проверяем есть ли приложение для его вызова. делать всегда
                Intent chooserIntent = Intent.createChooser ( intent, "Choose your destiny" );
                startActivity ( chooserIntent );
            } else {
                Toast.makeText ( this, "No Activity", Toast.LENGTH_SHORT ).show ();
            }
        } );

        calculateButton.setOnClickListener ( v -> {
            String message = messageEditText.getText ().toString ();
            Intent intent = new Intent ();
            intent.setAction ( "ru.gb.CALCULATE" );
//            intent.setType ( "plain/text" );//если закомитить эту строчку, то сработает проверка и выдаст сооющение toast
            intent.putExtra ( Intent.EXTRA_TEXT, message );
            if (intent.resolveActivity ( getPackageManager () ) != null) {// проверяем есть ли приложение для его вызова. делать всегда
                Intent chooserIntent = Intent.createChooser ( intent, "Choose your destiny" );
                startActivity ( chooserIntent );
            } else {
                Toast.makeText ( this, "No Activity", Toast.LENGTH_SHORT ).show ();
            }
        } );

    }

    @Override
    protected void onStop() {
        String echoText = echoTextView.getText ().toString ();
        if (!echoText.isEmpty ()) {
            getSharedPreferences ( PREF_NAME, MODE_PRIVATE ).edit ().putString ( ECHO_PREF_KEY, echoText ).apply ();
        }
        super.onStop ();
        Log.d ( TAG, "onStop" );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        Log.d ( TAG, "onStart" );
        String echo = getSharedPreferences ( PREF_NAME, MODE_PRIVATE ).getString ( ECHO_PREF_KEY, null );
        if (echo != null && !echo.isEmpty ()) {
            echoTextView.setText ( echo );
        }
    }

    @Override
    protected void onDestroy() {
        //Для очистки значений используйте методы SharedPreferences.Editor.remove(String key) и SharedPreferences.Editor.clear().
        Log.d ( TAG, "onDestroy" );
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            this.deleteSharedPreferences(ECHO_PREF_KEY);
//        } else {
//            try {
//                FileUtils.cleanDirectory(new File (this.getCacheDir().getParent() + "/shared_prefs/"));
//            } catch (IOException e) {
//                Log.d(TAG, "Cannot delete files in shared pref directory", e);
//            }
//        }
        super.onDestroy ();
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