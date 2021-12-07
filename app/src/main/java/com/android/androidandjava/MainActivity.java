package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<EntityConstructor> entities = new ArrayList<> ();

    private ActivityMainBinding binding;

    //создали переменную на основе interface InteractionListener в классе EntityListAdapter и переопледелили указанные в interface два метода
    private final EntityListAdapter.InteractionListener listener = new EntityListAdapter.InteractionListener () {
        @Override
        public void onItemShotClickListener(EntityConstructor entityConstructor) {
            String sb = "onItemShotClickListener - " +
                    entityConstructor.getTitle () +
                    "  :  " +
                    entityConstructor.getDetail ();
            Toast.makeText ( MainActivity.this, sb, Toast.LENGTH_LONG ).show ();
        }

        @Override
        public void onItemLongClickListener(EntityConstructor entityConstructor, View anchor) {
            String sb = "onItemLongClickListener - " +
                    entityConstructor.getTitle () +
                    "  :  " +
                    entityConstructor.getDetail ();
            Toast.makeText ( MainActivity.this, sb, Toast.LENGTH_LONG ).show ();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        binding = ActivityMainBinding.inflate ( getLayoutInflater () );
        setContentView ( binding.getRoot () );

        fillEntities ( 20 );

        initRecyclerView ();
    }

    private void initRecyclerView() {
        binding.listEntityRecyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        binding.listEntityRecyclerView.setAdapter ( new EntityListAdapter ( entities, listener ) );
    }

    private void fillEntities(int numberItems) {
        StringBuilder stringBuilder = new StringBuilder ();// с помощью класса StringBuilder создали пустую текстовую стоку
        stringBuilder.append ( "Title  " );// с помощью метода append в класса StringBuilder добавили в пустую созданную строку текст Title
        for (int i = 1; i <= numberItems; i++) {//цыкл, вызываем цыкл заданное количество раз (см. выше, вызвали метод N раз - fillEntities)
            stringBuilder.delete ( 6, 8 );//не понятно зачем удалять с 6 по 8 символ?
            stringBuilder.append ( i );//с помощью метода append в класса StringBuilder добавили к тексту Title порядковый номер (бежим по цыклу и каждый раз присваиваем номер i)
            //
            entities.add ( new EntityConstructor ( stringBuilder.toString (), "Lorem ipsum dolor sit amet, " +
                    "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                    "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo " +
                    "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat " +
                    "nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt " +
                    "mollit anim id est laborum." ) );

        }
    }
}