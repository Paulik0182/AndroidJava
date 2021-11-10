package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_frame_appcompatimageview_loyout );

        imageView = findViewById ( R.id.image_view1 );

        imageView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                imageView.setImageResource ( R.drawable.ic_launcher_background );
            }
        } );
    }
}