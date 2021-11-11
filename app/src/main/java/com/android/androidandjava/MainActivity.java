package com.android.androidandjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@@@ MainActivity"; //@@@ пометка по каторой будем искать, далее файл в который будем писать

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        findViewById ( R.id.button_activity2 ).setOnClickListener ( v -> {
            Intent intent = new Intent ( this, SecondActivity.class );
            startActivity ( intent );

            Log.d ( TAG, "Send Intent MainActivity -> SecondActivity" );
        } );

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