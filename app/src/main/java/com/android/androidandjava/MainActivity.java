package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final DossierEntity myDossier = new DossierEntity//задали данные в конструктор. конструктор в DossierEntity. если эту строку положить в обработчик кнопки , будет ошибка
            ( "Pavel", "Bob", "Bob@gmail.com" );

    ProfileFragment profileFragment = ProfileFragment.newInstance ( myDossier );//кладем данные во фрагмент

    private Button showButton;

    private static final String TAG = "@@@ MainActivity";// константа для лога

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        showButton = findViewById ( R.id.show_fragment_button );
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        showButton.setOnClickListener ( v -> {
            getSupportFragmentManager ()
                    .beginTransaction ()
                    .add ( R.id.fragment_container, profileFragment )
                    .commit ();
        } );
    }

    @Override
    protected void onStart() {
        super.onStart ();
        Log.d ( TAG, "onStart() called" );
    }

    @Override
    protected void onResume() {
        super.onResume ();
        Log.d ( TAG, "onResume() called" );
    }

    @Override
    protected void onPause() {
        super.onPause ();
        Log.d ( TAG, "onPause() called" );
    }

    @Override
    protected void onStop() {
        super.onStop ();
        Log.d ( TAG, "onStop() called" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        Log.d ( TAG, "onDestroy() called" );
    }
}