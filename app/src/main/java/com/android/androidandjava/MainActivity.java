package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText = null;
    private Button clickButton = null;
    private TextView resultTextView = null;
    private RadioButton usaRadioButton = null;
    private RadioButton eurRadioButton = null;
    private RadioButton chfRadioButton = null;

    private double currency = 0;

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
                final double volute = parseDoubleString ( inputSrt );

                //Создали переменную, присвоили ей уже обработанный в методе convert результат
                // (в метод convert положили значение текстового поля EditText)
                final double rubles = convert ( volute );

                final String resultString = String.valueOf ( rubles );// Создали переменную, привратили ее в строку

                resultTextView.setText ( resultString );//Кладем результат в поле TextView

//                Toast.makeText ( MainActivity.this, "Расчет окончен", Toast.LENGTH_SHORT ).show ();
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
        final double volute = input;

        View.OnClickListener radioButtonClickListener = new View.OnClickListener () {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked ();

                switch (v.getId ()) {
                    case R.id.usa_radio_button:
                        if (checked) {
                            currency = 30;
                        }
                        Toast.makeText ( MainActivity.this, "Конвертация Долларов США", Toast.LENGTH_SHORT ).show ();
                        break;

                    case R.id.eur_radio_button:
                        if (checked) {
                            currency = 40;
                        }
                        Toast.makeText ( MainActivity.this, "Конвертация Евро", Toast.LENGTH_SHORT ).show ();
                        break;

                    case R.id.chf_radio_button:
                        if (checked) {
                            currency = 10;
                        }
                        Toast.makeText ( MainActivity.this, "Конвертация Юань", Toast.LENGTH_SHORT ).show ();
                        break;

                    default:
                        break;
                }
            }
        };

        final double rubles = volute * currency;
        return rubles;
    }

    //Метод для инициализации элементов на экране (view моделе).
    private void initViews() {
        inputEditText = findViewById ( R.id.input_edit_text );
        clickButton = findViewById ( R.id.result_button );
        resultTextView = findViewById ( R.id.result_text_view );

        usaRadioButton = findViewById ( R.id.usa_radio_button );
        eurRadioButton = findViewById ( R.id.eur_radio_button );
        chfRadioButton = findViewById ( R.id.chf_radio_button );
    }
}