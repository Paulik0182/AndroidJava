package com.android.androidandjava;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_EXTRA_KEY = "message";

    private TextView echoTextView;
    private EditText messageEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        echoTextView = findViewById ( R.id.echo_text_view );
        messageEditText = findViewById ( R.id.message_edit_text );
        nextButton = findViewById ( R.id.next_button );

        nextButton.setOnClickListener ( v -> {
            Intent intent = new Intent ( this, SecondActivity.class );
            intent.putExtra ( MESSAGE_EXTRA_KEY, messageEditText.getText ().toString () );
            this.startActivity ( intent );
        } );

    }
}