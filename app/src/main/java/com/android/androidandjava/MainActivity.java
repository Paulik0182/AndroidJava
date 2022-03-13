package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText = null;
    private Button clickButton = null;
    private TextView resultTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        initViews ();

        clickButton.setOnClickListener ( new View.OnClickListener () {
            //код ниже будет выполняться только после нажатия на кнопку.
            @Override
            public void onClick(View v) {

                //Создали переменную, присвоили ей значение текстового поля
                final String inputSrt = inputEditText.getText ().toString ();

                // Создали переменную, производим проверку введенного значения, в поле можно ввести только целое число
                // (если в строке будут буквы, служебные символы, компилятор выдаст ошибку. На View в поле EditText прописать
                // строку разрешающую ввод только чисел android:inputType="number",
                // минус данного решения - можно ввести только целое число)
                final double dollars = parseDoubleString ( inputSrt );

                //Создали переменную, присвоили ей уже обработанный в методе convert результат
                // (в метод convert положили значение текстового поля EditText)
                final double rubles = convert ( dollars );

                final String resultString = String.valueOf ( rubles );// Создали переменную, привратили ее в строку

                resultTextView.setText ( resultString );//Кладем результат в поле TextView

                Toast.makeText ( MainActivity.this, "Расчет окончен", Toast.LENGTH_SHORT ).show ();
            }
        } );
    }

    //Метод проверки на формат введенного значения в поле EditText
    private double parseDoubleString(String inputSrt) {
        try {
            return Double.parseDouble ( inputSrt );//Приобразовываем ткст в число
        } catch (NumberFormatException nfe) {
            return 0d;
        }
    }

    //Метод принемающий строку EditText и возващает результат (проходит вычисление)
    private double convert(double input) {
        final double dollars = input;
        final double currency = 30;
        final double rubles = dollars * currency;
        return rubles;
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        inputEditText = findViewById ( R.id.input_edit_text );
        clickButton = findViewById ( R.id.result_button );
        resultTextView = findViewById ( R.id.result_text_view );
    }
}