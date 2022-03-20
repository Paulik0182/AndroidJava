package com.android.androidandjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "@@@MainSecond : ";

    public static final String CURRENCY_EXTRA_KEY = "currency";
    public static final String VALUE_EXTRA_KEY = "value";
    public static final String RESULT_EXTRA_KEY = "result";

    private Button exitButton = null;
    private TextView resultTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();//принимаем intent с первого окна
        //проверка на наличее значений, далее если значение пришли , выполняется код
        if (intent.hasExtra(CURRENCY_EXTRA_KEY) && intent.hasExtra(VALUE_EXTRA_KEY)) {
            double currency = intent.getDoubleExtra(CURRENCY_EXTRA_KEY, 0d);//принимаем значения
            double value = intent.getDoubleExtra(VALUE_EXTRA_KEY, 0d);//принимаем значения

            //присвоили переменной результат вычисления в методе convert, передали пришедшие значения в метод convert
            double result = convert(value, currency);
            //передаем в поле полученный результат
            resultTextView.setText(String.valueOf(result));

            Intent data = new Intent();//эта data из метода onActivityResult, это обертка для того чтобы отправить результат обратно
            setResult(Activity.RESULT_OK, data);
            data.putExtra(RESULT_EXTRA_KEY, result);// возврат результата
            //это положительный результат. В данном случае мы всегда делаем конвертацию.
            // Есть еще RESULT_CANCELED, в этом случае результат обратно не уйдет
            //Результат зафиксировался, но появится данный результат только после того как Activity будет закрыта
        }
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double value, double currency) {
        return value * currency;
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        exitButton = findViewById(R.id.exit_button);
        resultTextView = findViewById(R.id.currency_result_text_view);
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