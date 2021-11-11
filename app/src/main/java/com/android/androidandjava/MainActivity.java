package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class MainActivity extends AppCompatActivity {

    private AppCompatImageView imageView;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_frame_appcompatimageview_loyout );

        imageView = findViewById ( R.id.image_view1 );

        imageView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable1;
                drawable1 = getResources ().getDrawable ( R.drawable.ic_baseline_fingerprint_24 );
                Drawable drawable2;
                drawable2 = getResources ().getDrawable ( R.drawable.ic_launcher_background );
                if (drawable1 == null) {
                    imageView.setImageResource ( R.drawable.ic_baseline_fingerprint_24 );
                } else imageView.setImageResource ( R.drawable.ic_launcher_background );
            }
        } );
    }
}