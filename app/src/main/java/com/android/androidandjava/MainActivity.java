package com.android.androidandjava;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final DossierEntity myDossier = new DossierEntity//задали данные в конструктор. конструктор в DossierEntity. если эту строку положить в обработчик кнопки , будет ошибка
            ( "Pavel", "Bob", "Bob@gmail.com" );

    ProfileFragment profileFragment = new ProfileFragment ( myDossier );//кладем данные во фрагмент

    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        showButton = findViewById ( R.id.show_fragment_button );

        showButton.setOnClickListener ( v -> {
            getSupportFragmentManager ()
                    .beginTransaction ()
                    .add ( R.id.fragment_container, profileFragment )
                    .commit ();
        } );
    }
}