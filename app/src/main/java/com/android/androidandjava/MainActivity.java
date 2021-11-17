package com.android.androidandjava;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
//        setContentView ( R.layout.activity_main );
        setContentView ( R.layout.activity_test_thema );


        TextInputLayout textInputLayout = findViewById ( R.id.text_input_layout );
        TextInputEditText textInputEditText = findViewById ( R.id.text_input_edit_text );

        textInputEditText.setOnFocusChangeListener ( (v, hasFocus) -> textInputLayout.setError ( "Ошибка!" ) );

//        textInputEditText.setOnFocusChangeListener ( new View.OnFocusChangeListener () {//до приобразовании в лямду. см.выше
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                textInputLayout.setError ("Ошибка!");
//            }
//        } );

//        TextView textView = findViewById ( R.id.text_view );
//        textView.setText ( R.string.app_name );
//        String string = this.getResources ().getString ( R.string.greetings );
//        textView.setText ( string );
    }
}