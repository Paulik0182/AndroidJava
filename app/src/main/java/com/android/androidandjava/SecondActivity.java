package com.android.androidandjava;

import android.app.Activity;
import android.content.Context;
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

    private static final String SAVE_RECEIVE_TITLE_KEY = "save_receive_title_key";
    private static final String SAVE_RECEIVE_DETAIL_KEY = "save_receive_title_key";

    public static final String ENTITIES_OUT_EXTRA_KEY = "entities_out_extra_key";

    public static final String TITLE_EXTRA_KEY = "title_extra_key";
    public static final String DETAIL_EXTRA_KEY = "save_detail_key";

    public static final int ACTIVITY_REQUEST_CODE = 1111;


    private ActivitySecondBinding binding;

    private String receiveTitleSecondActivity = "";
    private String receiveDetailSecondActivity = "";

    public static Intent getLaunchIntent(Context context, EntityConstructor entityCons) {
        Intent intent = new Intent ( context, SecondActivity.class );
        intent.putExtra ( DETAIL_EXTRA_KEY, entityCons );
        return intent;
    }

    public static void launch(Context context, EntityConstructor entityConstructor) {
        Intent intent = new Intent ( context, SecondActivity.class );

        intent.putExtra ( TITLE_EXTRA_KEY, entityConstructor.getTitle () );
        intent.putExtra ( DETAIL_EXTRA_KEY, entityConstructor.getDetail () );

        context.startActivity ( intent );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "SecondActivity : onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivitySecondBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        Intent intent = getIntent ();
        receiveTitleSecondActivity = intent.getStringExtra ( TITLE_EXTRA_KEY );
        receiveDetailSecondActivity = intent.getStringExtra ( DETAIL_EXTRA_KEY );
        binding.echoTextView.setText ( receiveTitleSecondActivity );
        binding.messageEditText.setText ( receiveDetailSecondActivity );

        binding.okButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Log.d ( TAG, "onClick() called with: v = [" + v + "]" );
                Intent intent = new Intent ();
                intent.putExtra ( TITLE_OUT_EXTRA_KEY, receiveTitleSecondActivity );
                intent.putExtra ( DETAIL_OUT_EXTRA_KEY, receiveDetailSecondActivity );
                setResult ( Activity.RESULT_OK, intent );
                finish ();
            }
        } );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d ( TAG, "onSaveInstanceState() called with: outState = [" + outState + "]" );

        outState.putString ( SAVE_RECEIVE_TITLE_KEY, receiveTitleSecondActivity );
        outState.putString ( SAVE_RECEIVE_DETAIL_KEY, receiveDetailSecondActivity );
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d ( TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]" );

        if (savedInstanceState.containsKey ( SAVE_RECEIVE_TITLE_KEY )) {
            receiveTitleSecondActivity = savedInstanceState.getParcelable ( SAVE_RECEIVE_TITLE_KEY );
        }
        binding.echoTextView.setText ( receiveTitleSecondActivity );

        if (savedInstanceState.containsKey ( SAVE_RECEIVE_DETAIL_KEY )) {
            receiveDetailSecondActivity = savedInstanceState.getParcelable ( SAVE_RECEIVE_DETAIL_KEY );
        }
        binding.messageEditText.setText ( receiveDetailSecondActivity );

        super.onRestoreInstanceState ( savedInstanceState );
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

    @Override
    public void onBackPressed() {
        Log.d ( TAG, "onBackPressed() called" );

        Intent intent = new Intent ();
        intent.putExtra ( TITLE_OUT_EXTRA_KEY, receiveTitleSecondActivity );
        intent.putExtra ( DETAIL_OUT_EXTRA_KEY, receiveDetailSecondActivity );
        setResult ( Activity.RESULT_OK, intent );
        finish ();
    }
}
