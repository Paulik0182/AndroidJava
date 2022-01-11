package com.android.androidandjava;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ListFragment.Contract {

    private static final String TAG = "@@@ MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        FragmentManager fragmentManager = getSupportFragmentManager ();
        fragmentManager.beginTransaction ()
                .add ( binding.listFragmentContainer.getId (), new ListFragment () )
                .commit ();
    }

    //реализация контракта
    @Override
    public void showDetail(String message) {//передаем данные из фрагмента в фрагмент
        Log.d ( TAG, "showDetail() called" );
        FragmentManager fragmentManager = getSupportFragmentManager (); //создаем экземпляр фрагмента
        fragmentManager.beginTransaction () //запускаем транзакцию
                //replace - заменить фрагмент. Меняем фрагмент контейнера один на другой
                .replace ( binding.detailFragmentContainer.getId (), DetailFragment.newInstance ( message ) )
                .commit ();//завершение транзакции
    }

    @Override
    protected void onStart() {
        Log.d ( TAG, "onStart() called" );
        super.onStart ();
    }

    @Override
    protected void onResume() {
        Log.d ( TAG, "onResume() called" );
        super.onResume ();
    }

    @Override
    protected void onPause() {
        Log.d ( TAG, "onPause() called" );
        super.onPause ();
    }

    @Override
    protected void onStop() {
        Log.d ( TAG, "onStop() called" );
        super.onStop ();
    }

    @Override
    protected void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }

}