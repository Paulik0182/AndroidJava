package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.androidandjava.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "@@@SecondActivity";

    private ActivitySecondBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "SecondActivity : onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState ( savedInstanceState );
    }

    @Override
    protected void onStart() {
        super.onStart ();
    }

    @Override
    protected void onResume() {
        super.onResume ();
    }

    @Override
    protected void onPause() {
        super.onPause ();
    }

    @Override
    protected void onStop() {
        super.onStop ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
    }
}
