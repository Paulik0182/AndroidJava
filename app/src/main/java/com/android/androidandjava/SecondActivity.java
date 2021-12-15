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
    private static final String SAVE_RECEIVE_TITLE_KEY = "save_receive_title_key";
    public static final String DETAIL_OUT_EXTRA_KEY = "detail_out_extra_key";
    public static final String ENTITIES_OUT_EXTRA_KEY = "entities_out_extra_key";

    private ActivitySecondBinding binding;

    private String receiveTitleSecondActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "SecondActivity : onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );


//        if (getIntent ().hasExtra ( MainActivity.SAVE_TITLE_KEY )) {
//            binding.echoTextView.setText ( getIntent ().getStringExtra ( MainActivity.SAVE_TITLE_KEY ) );
//        }

        Intent intent = getIntent ();
        receiveTitleSecondActivity = intent.getParcelableExtra ( MainActivity.SAVE_TITLE_KEY );
        binding.echoTextView.setText ( getIntent ().getStringExtra ( String.valueOf ( receiveTitleSecondActivity ) ) );

        binding.okButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.d ( TAG, "onClick() called with: v = [" + v + "]" );
                Intent intent = new Intent ();
                intent.putExtra ( TITLE_OUT_EXTRA_KEY, String.valueOf ( receiveTitleSecondActivity ) );
                setResult ( Activity.RESULT_OK, intent );
                finish ();
            }
        } );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d ( TAG, "onSaveInstanceState() called with: outState = [" + outState + "]" );
        outState.putString ( SAVE_RECEIVE_TITLE_KEY, String.valueOf ( receiveTitleSecondActivity ) );
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d ( TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]" );
        if (savedInstanceState.containsKey ( SAVE_RECEIVE_TITLE_KEY )) {
            receiveTitleSecondActivity = savedInstanceState.getString ( SAVE_RECEIVE_TITLE_KEY, String.valueOf ( receiveTitleSecondActivity ) );
        }
        binding.echoTextView.setText ( String.valueOf ( receiveTitleSecondActivity ) );
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
        intent.putExtra ( TITLE_OUT_EXTRA_KEY, String.valueOf ( receiveTitleSecondActivity ) );
        setResult ( Activity.RESULT_OK, intent );
        finish ();
    }
}
