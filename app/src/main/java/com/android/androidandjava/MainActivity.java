package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@MainActivity";
    public static final String TITLE_EXTRA_KEY = "title_extra_key";

    public static final String DETAIL_EXTRA_KEY = "save_detail_key";
    private static final String SAVE_DETAIL_KEY = "save_detail_key";
    private static final String SAVE_TITLE_KEY = "save_title_key";
    private static final String SAVE_ENTITIES_KEY = "save_entities_key";

    private static final String TITLE_SAVE_OUT_EXTRA_KEY = "title_save_out_extra_key";
    private static final String DETAIL_SAVE_OUT_EXTRA_KEY = "detail_save_out_extra_key";


    private final ArrayList<EntityConstructor> entities = new ArrayList<> ();// определяем список

    private ActivityMainBinding binding;

//    public EntityConstructor entityCons = new EntityConstructor ();

    private String receiveTitleMainActivity = "";
    private String receiveDetailMainActivity = "";

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

            Intent intent = new Intent ( MainActivity.this, SecondActivity.class );

            intent.putExtra ( TITLE_EXTRA_KEY, entityConstructor.getTitle () );
            intent.putExtra ( DETAIL_EXTRA_KEY, entityConstructor.getDetail () );

//            startActivity ( intent );
            startActivityForResult ( intent, SecondActivity.ACTIVITY_REQUEST_CODE );

            Log.d ( TAG, "Listener Sort" );
        }


        @SuppressLint("LongLogTag")
        @Override
        public void onItemLongClickListener(EntityConstructor entityConstructor) {
            Toast.makeText ( MainActivity.this, "onItemLongClickListener ->" +
                    entityConstructor.getTitle (), Toast.LENGTH_LONG ).show ();

            Log.d ( TAG, "Listener Long" );
        }
    };

    public MainActivity() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        fillEntities ();
        Log.d ( TAG, "onCreate" );

        Intent intent = getIntent ();
        receiveTitleMainActivity = intent.getStringExtra ( TITLE_SAVE_OUT_EXTRA_KEY );
        receiveDetailMainActivity = intent.getStringExtra ( DETAIL_SAVE_OUT_EXTRA_KEY );
        entities.add ( new EntityConstructor ( receiveTitleMainActivity, receiveDetailMainActivity ) );//выводим данные


        Toast.makeText ( MainActivity.this,
                entities.get ( 1 ).getDetail (), Toast.LENGTH_SHORT ).show ();

//        binding.listEntityRecyclerView.setTooltipText ( String.valueOf ( getTitle () ) );
//        binding.listEntityRecyclerView.setTooltipText ( String.valueOf ( getDetail () ) );
//        binding.listEntityRecyclerView.setAdapter ( entities.indexOf ( listener ) );
//        binding.listEntityRecyclerView.setAdapter ( getPackageManager ().getPackagesHoldingPermissions (entities) );
//        binding.listEntityRecyclerView.setAdapter ( (RecyclerView.Adapter) listener );
        binding.listEntityRecyclerView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
//                SecondActivity.launch ( v.getContext (), (EntityConstructor) getTitle () );
//                Intent intent = SecondActivity.getLaunchIntent(v.getContext(),  );
//                startActivityForResult(intent, SecondActivity.ACTIVITY_REQUEST_CODE);

            }
        } );
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
        outState.putString ( SAVE_TITLE_KEY, receiveTitleMainActivity );
        outState.putString ( SAVE_TITLE_KEY, receiveDetailMainActivity );

        Log.d ( TAG, "onSaveInstanceState() called with: outState = [" + outState + "]" );
        super.onSaveInstanceState ( outState );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        if (savedInstanceState.containsKey ( SAVE_TITLE_KEY )) {
//            titleMainActivity = savedInstanceState.getParcelable ( SAVE_TITLE_KEY );
//        }
//        binding.listEntityRecyclerView.setTooltipText ( String.valueOf ( getTitle () ) );
        Log.d ( TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onRestoreInstanceState ( savedInstanceState );
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//функция для того, чтобы вытинуть из второй активити сохнаненные там значения
        super.onActivityResult ( requestCode, resultCode, data );

        if (requestCode == SecondActivity.ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) { // проверили, что ECHO_REQUEST_CODE соответствует запуску конкретной активити. RESULT_OK о том что все хорошо

            if (data != null && data.hasExtra ( SecondActivity.TITLE_OUT_EXTRA_KEY ) &&
                    data.hasExtra ( SecondActivity.DETAIL_OUT_EXTRA_KEY )) { //проверяем на то что данные которые пришли не равны null, и есть такой ключь RESULT_EXTRA_KEY

                String echoTitle = data.getStringExtra ( SecondActivity.TITLE_OUT_EXTRA_KEY );//получаем данные по ключу
                String echoDetail = data.getStringExtra ( SecondActivity.DETAIL_OUT_EXTRA_KEY );//получаем данные по ключу

                entities.add ( new EntityConstructor ( echoTitle, echoDetail ) );//выводим данные
            }
        }
    }

}