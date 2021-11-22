package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        showButton = findViewById ( R.id.show_fragment_button );

        showButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment ();
                getSupportFragmentManager ()
                        .beginTransaction ()
                        .add ( R.id.fragment_container, profileFragment )
                        .commit ();
            }
        } );
    }
}