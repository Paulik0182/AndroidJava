package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "@@@MainActivity";

    private static final String SAVE_DETAIL_KEY = "save_detail_key";
    private static final String SAVE_TITLE_KEY = "save_title_key";

    private static final String TITLE_SAVE_OUT_EXTRA_KEY = "title_save_out_extra_key";
    private static final String DETAIL_SAVE_OUT_EXTRA_KEY = "detail_save_out_extra_key";


    private final ArrayList<EntityConstructor> entities = new ArrayList<> ();// определяем список

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> secondActivityLauncher;

    private final String receiveUidMainActivity = "";
    private String receiveTitleMainActivity = "";
    private String receiveDetailMainActivity = "";

    private EntityListAdapter adapter;

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

            //Обращение к второй активити SecondActivity через метот во втором классе с возможностью возврата обработаных данных
            Intent intent = SecondActivity.getLaunchIntent ( binding.listEntityRecyclerView.getContext (),
                    entityConstructor.getTitle (),
                    entityConstructor.getDetail () );//как правильно обратится к методу в классе SecondActivity
            secondActivityLauncher.launch ( intent );

            Log.d ( TAG, "Listener Sort" );
        }

        @SuppressLint("LongLogTag")
        @Override
        public void onItemLongClickListener(EntityConstructor entityConstructor, View anchor) {// anchor - это элемент в меню на который мы нажимаем

            Log.d ( TAG, "onItemLongClickListener() called with: entityConstructor = " +
                    "[" + entityConstructor + "], anchor = [" + anchor + "]" );

            Toast.makeText ( MainActivity.this, "onItemLongClickListener ->" +
                    entityConstructor.getTitle (), Toast.LENGTH_LONG ).show ();

            showItemEntityPopupMenu ( entityConstructor, anchor );//вызов метода. Всплывающее меню
        }
    };

    //метод всплывающего меню (и реализация нажатия кнопок: добавить, удалить, удалить все)
    private void showItemEntityPopupMenu(EntityConstructor entityConstructor, View anchor) {//передаем entityConstructor - это запись, anchor - это элемент на который мы нажимаем
        PopupMenu popupMenu = new PopupMenu ( this, anchor );//создали меню, в него передали контекст и view
        popupMenu.inflate ( R.menu.menu_entity );// раздули view (layout menu)

        //слушатель нажатий меню (выбор меню)
        popupMenu.setOnMenuItemClickListener ( new PopupMenu.OnMenuItemClickListener () {
            @Override
            public boolean onMenuItemClick(MenuItem item) {//передается нажатый элемент (item)

                int itemId = item.getItemId ();

                //проверяем какой элемент нажат и выполняем действия (логика)
                if (itemId == R.id.menu_entity_add) {//добавляем элемент
                    Toast.makeText ( MainActivity.this, "Menu: Add", Toast.LENGTH_SHORT ).show ();
                    addEntity ( entityConstructor );
//                    inUpdate ();
                    return true;

                } else if (itemId == R.id.menu_entity_delete) {//удаляем элемент
                    Toast.makeText ( MainActivity.this, "Menu: Delete", Toast.LENGTH_SHORT ).show ();
                    deleteEntity ( entityConstructor );
//                    inUpdate ();
                    return true;

                } else if (itemId == R.id.menu_entity_delete_all) {//удаляем все элементы
                    Toast.makeText ( MainActivity.this, "Menu: Delete_all", Toast.LENGTH_SHORT ).show ();
                    deleteAllEntity ();
//                    inUpdate ();
                    return true;

                }
                return false;
            }
        } );

        popupMenu.setOnDismissListener ( new PopupMenu.OnDismissListener () {
            @Override
            public void onDismiss(PopupMenu menu) {//завершение обработки нажатия, как правило не используется
                Toast.makeText ( MainActivity.this, "Menu: on dismiss", Toast.LENGTH_SHORT ).show ();
            }
        } );

        popupMenu.show ();
    }

    private void addEntity(EntityConstructor entityConstructor) {
        //Обращение ко второй активити SecondActivity
        Intent intent = new Intent ( MainActivity.this, SecondActivity.class );

//        intent.putExtra ( SecondActivity.TITLE_EXTRA_KEY, entityConstructor.getTitle () );
//        intent.putExtra ( SecondActivity.DETAIL_EXTRA_KEY, entityConstructor.getDetail () );
//
////            startActivity ( intent );
        startActivityForResult ( intent, SecondActivity.ACTIVITY_REQUEST_CODE );

//        ArrayList<EntityConstructor> oldEntities = new ArrayList<> ( entities );
//        entities.add ( new EntityConstructor ( "test", "addTest", "Text_test" ) );
//        entityListUpdate ( oldEntities, entities );
    }

    private void deleteEntity(EntityConstructor entityConstructor) {
        ArrayList<EntityConstructor> oldEntities = new ArrayList<> ( entities );
        entities.remove ( entityConstructor );
        entityListUpdate ( oldEntities, entities );
    }

    private void deleteAllEntity() {
        ArrayList<EntityConstructor> oldEntities = new ArrayList<> ( entities );
        entities.clear ();
        entityListUpdate ( oldEntities, entities );
    }

    //в метод передается два массива, старый и новый
    private void entityListUpdate(List<EntityConstructor> oldEntities, List<EntityConstructor> newEntities) {
        EntityDiffUtil entityDiffUtil = new EntityDiffUtil ( oldEntities, newEntities );//инициализация списков через класс EntityDiffUtil
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff ( entityDiffUtil, true );//вычисление разницы между двумя масивами
        diffResult.dispatchUpdatesTo ( adapter );//формируется новый список данных (массив данных)
        adapter.setData ( newEntities );//передаем новый список
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        fillEntities ( 20 );

        initRecyclerView ();
//        inUpdate ();

        secondActivityLauncher = registerForActivityResult ( new ActivityResultContracts.StartActivityForResult (), new ActivityResultCallback<ActivityResult> () {
            @Override
            public void onActivityResult(ActivityResult result) {
                Log.d ( TAG, "onActivityResult() called with: result = [" + result + "]" );
                if (result.getResultCode () == Activity.RESULT_OK) {
                    Intent data = result.getData ();
                    assert data != null;
                    receiveTitleMainActivity = data.getStringExtra ( SecondActivity.TITLE_OUT_EXTRA_KEY );
                    receiveDetailMainActivity = data.getStringExtra ( SecondActivity.DETAIL_OUT_EXTRA_KEY );
//                    inUpdate ();
                }
            }
        } );

        Log.d ( TAG, "onCreate" );
    }

    private void initRecyclerView() {
        Log.d ( TAG, "initRecyclerView()" );
        //устанавливаем layout. Раздуваем вертикальный или горизонтальный список
        binding.listEntityRecyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        adapter = new EntityListAdapter ( entities, listener );
        //устанавливаем адаптер. Вызываем конструктор адаптера
        binding.listEntityRecyclerView.setAdapter ( adapter );
    }

    private void fillEntities(int numberItems) {
        StringBuilder sb = new StringBuilder ();
        sb.append ( "Title  " );
        for (int i = 1; i <= numberItems; i++) {
            sb.delete ( 6, 8 );
            sb.append ( i );
            String uid = UUID.randomUUID ().toString ();
            entities.add ( new EntityConstructor ( uid, sb.toString (), "Text" ) );

        }
    }
    //наполняем список
//    private void fillEntities() {
//        entities.add ( new EntityConstructor ( "1","Title_1", "Text" ) );
//        entities.add ( new EntityConstructor ( "2","Title_2", "Text" ) );
//        entities.add ( new EntityConstructor ( "3","Title_3", "Text" ) );
//        entities.add ( new EntityConstructor ( "4","Title_4", "Text" ) );
//        entities.add ( new EntityConstructor ( "5","Title_5", "Text" ) );
//        entities.add ( new EntityConstructor ( "6","Title_6", "Text" ) );
//        entities.add ( new EntityConstructor ( "7","Title_7", "Text" ) );
//        entities.add ( new EntityConstructor ( "8","Title_8", "Text" ) );
//        entities.add ( new EntityConstructor ( "9","Title_9", "Text" ) );
//        entities.add ( new EntityConstructor ( "10","Title_10", "Text" ) );
//        entities.add ( new EntityConstructor ( "11","Title_11", "Text" ) );
//        entities.add ( new EntityConstructor ( "12","Title_12", "Text" ) );
//        entities.add ( new EntityConstructor ( "13","Title_13", "Text" ) );
//        entities.add ( new EntityConstructor ( "14","Title_14", "Text" ) );
//        entities.add ( new EntityConstructor ( "15","Title_15", "Text" ) );
//        entities.add ( new EntityConstructor ( "16","Title_16", "Text" ) );
//        entities.add ( new EntityConstructor ( "17","Title_17", "Text" ) );
//        entities.add ( new EntityConstructor ( "18","Title_18", "Text" ) );
//        entities.add ( new EntityConstructor ( "19","Title_19", "Text" ) );
//        entities.add ( new EntityConstructor ( "20","Title_20", "Text" ) );
//
//    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString ( SAVE_TITLE_KEY, receiveTitleMainActivity );
        outState.putString ( SAVE_DETAIL_KEY, receiveDetailMainActivity );

        Log.d ( TAG, "onSaveInstanceState() called with: outState = [" + outState + "]" );
        super.onSaveInstanceState ( outState );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d ( TAG, "onRestoreInstanceState() called with: savedInstanceState = [" + savedInstanceState + "]" );

        if (savedInstanceState.containsKey ( SAVE_TITLE_KEY )) {
            receiveTitleMainActivity = savedInstanceState.getString ( SAVE_TITLE_KEY );
        }

        if (savedInstanceState.containsKey ( SAVE_DETAIL_KEY )) {
            receiveDetailMainActivity = savedInstanceState.getString ( SAVE_DETAIL_KEY );
        }

        entities.add ( new EntityConstructor ( receiveUidMainActivity, receiveTitleMainActivity, receiveDetailMainActivity ) );
//        inUpdate ();

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

//    @RequiresApi(api = Build.VERSION_CODES.O)
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//функция для того, чтобы вытинуть из второй активити сохнаненные там значения
//        super.onActivityResult ( requestCode, resultCode, data );
//
//        if (requestCode == SecondActivity.ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) { // проверили, что ECHO_REQUEST_CODE соответствует запуску конкретной активити. RESULT_OK о том что все хорошо
//
//            if (data != null && data.hasExtra ( SecondActivity.TITLE_OUT_EXTRA_KEY ) &&
//                    data.hasExtra ( SecondActivity.DETAIL_OUT_EXTRA_KEY )) { //проверяем на то что данные которые пришли не равны null, и есть такой ключь RESULT_EXTRA_KEY
//
//                String echoTitle = data.getStringExtra ( SecondActivity.TITLE_OUT_EXTRA_KEY );//получаем данные по ключу
//                String echoDetail = data.getStringExtra ( SecondActivity.DETAIL_OUT_EXTRA_KEY );//получаем данные по ключу
//
//                entities.add ( new EntityConstructor ( echoTitle, echoDetail ) );//выводим данные
//                inUpdate ();
//            }
//        }
    //Вариант 2
//        if (requestCode == SecondActivity.ACTIVITY_REQUEST_CODE && data != null && resultCode == Activity.RESULT_OK) {
//            receiveTitleMainActivity = data.getStringExtra (SecondActivity.TITLE_EXTRA_KEY);
//            receiveDetailMainActivity = data.getStringExtra (SecondActivity.DETAIL_EXTRA_KEY);
//            entities.add ( new EntityConstructor ( receiveTitleMainActivity, receiveDetailMainActivity ) );//выводим данные
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

//    private void inUpdate() {
//        adapter.setData ( entities );
//    }
}