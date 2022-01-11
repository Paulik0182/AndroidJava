package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@ MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        binding.launchFragmentButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager ();
                fragmentManager.beginTransaction ()
                        .add ( binding.listFragmentContainer.getId (), new ListFragment () )
                        .addToBackStack ( null )
                        .commit ();
            }
        } );
    }

    @Override
    protected void onStart() {
        Log.d ( TAG, "onStart() called" );
        super.onStart ();
    }

    @Override
    protected void onResume() {
        Log.d ( TAG, "onResume() called" );
        super.onResume ();
    }

    @Override
    protected void onPause() {
        Log.d ( TAG, "onPause() called" );
        super.onPause ();
    }

    @Override
    protected void onStop() {
        Log.d ( TAG, "onStop() called" );
        super.onStop ();
    }

    @Override
    protected void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }

}