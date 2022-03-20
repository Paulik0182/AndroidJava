package com.android.androidandjava;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setupListeners();
    }

    private void setupListeners() {
        //код ниже будет выполняться только после нажатия на кнопку.
        conversionButton.setOnClickListener(v -> {
            openResultScreen();
        });
    }

    //Метод проверки на формат введенного значения в поле EditText
    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble(inputSrt);//Приобразовываем ткст в число
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    private double getCurrencyFromScreen() {
        //Вариант 1. обработка RadioGroup. наиболее предпочтителен
        switch (currencyRadioGroup.getCheckedRadioButtonId()) {
            case R.id.usa_currency_radio_button:
                return RUB_IN_USD;
            case R.id.eur_currency_radio_button:
                return RUB_IN_EUR;
            case R.id.chf_currency_radio_button:
                return RUB_IN_CHF;
            default:
                return 0;
        }
    }

    private void openResultScreen() {
        //Создали переменную, присвоили ей значение текстового поля
        final String inputSrt = inputEditText.getText().toString();

        // Создали переменную, производим проверку введенного значения, в поле можно ввести только целое число
        // (если в строке будут буквы, служебные символы, компилятор выдаст ошибку. На View в поле EditText прописать
        // строку разрешающую ввод только чисел android:inputType="number",
        // минус данного решения - можно ввести только целое число)
        final double value = parseDoubleString(inputSrt);
        final double currency = getCurrencyFromScreen();

        //Открытие второго окна
        Intent intent = new Intent(this, SecondActivity.class);

        //при открытии второго окна кладем дополнительные значения в формате: ключь, значение.
        intent.putExtra(SecondActivity.CURRENCY_EXTRA_KEY, currency);//значение - стоимость волюты
        intent.putExtra(SecondActivity.VALUE_EXTRA_KEY, value);//введенное значение в строку EditText - сколько волюты нужно конвертировать

        startActivity(intent);

        Toast.makeText(MainActivity.this, "Second Activity", Toast.LENGTH_SHORT).show();
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double volute) {
        Log.d(TAG, "convert() called with: input = [" + volute + "]");
        return volute * getCurrencyFromScreen();
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        inputEditText = findViewById(R.id.input_edit_text);
        conversionButton = findViewById(R.id.result_button);
        openScreenSecondButton = findViewById(R.id.open_second_button);
        resultTextView = findViewById(R.id.result_text_view);

        currencyRadioGroup = findViewById(R.id.currency_radio_group);
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
}