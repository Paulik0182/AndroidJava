package com.android.androidandjava;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.androidandjava.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Entity> entities = new ArrayList<> ();

    private ActivityMainBinding binding;
    private final EntityListAdapter.InteractionListener listener = new EntityListAdapter.InteractionListener () {
        @Override
        public void onItemShotClickListener(Entity entity) {
            String sb = "onItemShotClickListener - " +
                    entity.getTitle () +
                    "  :  " +
                    entity.getDetail ();
            Toast.makeText ( MainActivity.this, sb, Toast.LENGTH_LONG ).show ();
        }

        @Override
        public void onItemLongClickListener(Entity entity, View anchor) {
            String sb = "onItemLongClickListener - " +
                    entity.getTitle () +
                    "  :  " +
                    entity.getDetail ();
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
        StringBuilder sb = new StringBuilder ();
        sb.append ( "Title  " );
        for (int i = 1; i <= numberItems; i++) {
            sb.delete ( 6, 8 );
            sb.append ( i );
            entities.add ( new Entity ( sb.toString (), "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum." ) );

        }
    }
}