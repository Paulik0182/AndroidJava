package com.android.androidandjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@MainActivity : ";

    private static final int RUB_IN_USD = 30;
    private static final int RUB_IN_EUR = 40;
    private static final int RUB_IN_CHF = 10;

    private EditText inputEditText = null;
    private Button conversionButton = null;
    private Button openScreenSecondButton = null;
    private TextView resultTextView = null;

    private RadioGroup currencyRadioGroup = null;
    private RadioButton usaRadioButton = null;

    private double currency = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupListeners();
    }

    private void setupListeners() {
        conversionButton.setOnClickListener(new View.OnClickListener() {
            //код ниже будет выполняться только после нажатия на кнопку.
            @Override
            public void onClick(View v) {

                //Создали переменную, присвоили ей значение текстового поля
                final String inputSrt = inputEditText.getText().toString();

                // Создали переменную, производим проверку введенного значения, в поле можно ввести только целое число
                // (если в строке будут буквы, служебные символы, компилятор выдаст ошибку. На View в поле EditText прописать
                // строку разрешающую ввод только чисел android:inputType="number",
                // минус данного решения - можно ввести только целое число)
                final double volute = parseDoubleString(inputSrt);

                //Создали переменную, присвоили ей уже обработанный в методе convert результат
                // (в метод convert положили значение текстового поля EditText)
                final double rubles = convert(volute);

                final String resultString = String.valueOf(rubles);// Создали переменную, привратили ее в строку

                resultTextView.setText(resultString);//Кладем результат в поле TextView

//                Toast.makeText ( MainActivity.this, "Расчет окончен", Toast.LENGTH_SHORT ).show ();
            }
        });

        openScreenSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Second Activity", Toast.LENGTH_SHORT).show();
            }
        });

        // setOnCheckedChangeListener - повесить слушатель на изменение выбора
        // Вариант 2. обработка RadioGroup. Менее предпочтителен, необходимо принудительно (программно) кликать на кнопку.
        currencyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.usa_currency_radio_button:
                        currency = RUB_IN_USD;
                        break;
                    case R.id.eur_currency_radio_button:
                        currency = RUB_IN_EUR;
                        break;
                    case R.id.chf_currency_radio_button:
                        currency = RUB_IN_CHF;
                        break;
                }
            }
        });
        //программно кликаем на данный RadioButton. При создании экрана, слушатель ожидает нажатия
        // на RadioButton, в данном случае мы уже выбрали свой вариант.
        usaRadioButton.performClick();
    }

    //Метод проверки на формат введенного значения в поле EditText
    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble(inputSrt);//Приобразовываем ткст в число
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double volute) {

        //Вариант 1. обработка RadioGroup. наиболее предпочтителен
//        switch (currencyRadioGroup.getCheckedRadioButtonId()) {
//            case R.id.usa_currency_radio_button:
//                currency = RUB_IN_USD;
//                break;
//            case R.id.eur_currency_radio_button:
//                currency = RUB_IN_EUR;
//                break;
//            case R.id.chf_currency_radio_button:
//                currency = RUB_IN_CHF;
//                break;
//        }
        final double rubles = volute * currency;

        Log.d(TAG, "convert() called with: input = [" + volute + "]");

        return rubles;
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        inputEditText = findViewById(R.id.input_edit_text);
        conversionButton = findViewById(R.id.result_button);
        openScreenSecondButton = findViewById(R.id.open_second_button);
        resultTextView = findViewById(R.id.result_text_view);

        currencyRadioGroup = findViewById(R.id.currency_radio_group);
        usaRadioButton = findViewById(R.id.usa_currency_radio_button);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}