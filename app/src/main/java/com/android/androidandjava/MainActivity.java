package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText = null;
    private Button clickButton = null;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initViews ();

        clickButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                final String inputSrt = inputEditText.getText ().toString ();
                final double dollars = parseDoubleString ( inputSrt );
                final double rubles = convert ( dollars );
                final String resultString = String.valueOf ( rubles );
                resultTextView.setText ( resultString );
            }
        } );
    }

    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble ( inputSrt );
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private double convert(double input) {
        final double dollars = input;
        final double currency = 30;
        final double rubles = dollars * currency;
        return rubles;
    }

    private void initViews() {
        inputEditText = findViewById ( R.id.input_edit_text );
        clickButton = findViewById ( R.id.result_button );
        resultTextView = findViewById ( R.id.result_text_view );
    }
}