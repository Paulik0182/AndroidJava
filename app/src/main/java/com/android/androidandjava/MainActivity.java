package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@MainActivity";

    private final ArrayList<EntityConstructor> entities = new ArrayList<> ();// определяем список

    private ActivityMainBinding binding;

    //создали экземпляр ананимного класса (слушателя)
    private final OnItemInteractionListener listener = new OnItemInteractionListener () {
        @SuppressLint("LongLogTag")
        @Override
        public void onItemShotClickListener(EntityConstructor entityConstructor) {
            Toast.makeText ( MainActivity.this, "onItemShotClickListener ->"
                            + entityConstructor.getTitle ()
                            + "\n"
                            + entityConstructor.getDetail (),
                    Toast.LENGTH_LONG ).show ();
            Log.d ( TAG, "Listener Sort" );
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onItemLongClickListener(EntityConstructor entityConstructor) {
            Toast.makeText ( MainActivity.this, "onItemLongClickListener ->" +
                    entityConstructor.getTitle (), Toast.LENGTH_LONG ).show ();

            Intent intent = new Intent ( MainActivity.this, SecondActivity.class );
            startActivity ( intent );

            Log.d ( TAG, "Listener Long" );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );
        Log.d ( TAG, "onCreate" );

        fillEntities ();
        initRecyclerView ();
    }

    private void initRecyclerView() {
        Log.d ( TAG, "initRecyclerView()" );
        //устанавливаем layout. Раздуваем вертикальный или горизонтальный список
        binding.listEntityRecyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        //устанавливаем адаптер. Вызываем конструктор адаптера
        binding.listEntityRecyclerView.setAdapter ( new EntityListAdapter ( entities, listener ) );
    }

    //наполняем список
    private void fillEntities() {
        entities.add ( new EntityConstructor ( "Title_1", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_2", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_3", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_4", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_5", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_6", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_7", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_8", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_9", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_10", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_11", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_12", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_13", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_14", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_15", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_16", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_17", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_18", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_19", "Text" ) );
        entities.add ( new EntityConstructor ( "Title_20", "Text" ) );

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState ( savedInstanceState );
    }

    @Override
    protected void onStart() {
        super.onStart ();
    }

    @Override
    protected void onResume() {
        super.onResume ();
    }

    @Override
    protected void onPause() {
        super.onPause ();
    }

    @Override
    protected void onStop() {
        super.onStop ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
    }

}