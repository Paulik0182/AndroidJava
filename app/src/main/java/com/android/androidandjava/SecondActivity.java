package com.android.androidandjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.androidandjava.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "@@@SecondActivity";

    public static final String TITLE_OUT_EXTRA_KEY = "title_out_extra_key";
    public static final String DETAIL_OUT_EXTRA_KEY = "detail_out_extra_key";
    public static final String ENTITIES_OUT_EXTRA_KEY = "entities_out_extra_key";

    private ActivitySecondBinding binding;

    private String receiveTitle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "SecondActivity : onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        Intent intent = getIntent ();
        receiveTitle = intent.getParcelableExtra ( MainActivity.SAVE_TITLE_KEY );

        binding.echoTextView.setText ( String.valueOf ( receiveTitle ) );

        binding.okButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.d ( TAG, "onClick() called with: v = [" + v + "]" );
                Intent intent = new Intent ();
                intent.putExtra ( TITLE_OUT_EXTRA_KEY, receiveTitle );
                setResult ( Activity.RESULT_OK, intent );
                finish ();
            }
        } );
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

    @Override
    public void onBackPressed() {
        Log.d ( TAG, "onBackPressed() called" );
        Intent intent = new Intent ();
        intent.putExtra ( TITLE_OUT_EXTRA_KEY, receiveTitle );
        setResult ( Activity.RESULT_OK, intent );
        finish ();
    }
}
