package com.android.androidandjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;

import java.util.ArrayList;
import java.util.List;


public class EntityListAdapter extends RecyclerView.Adapter<EntityItemHolder> {

    private final ArrayList<EntityConstructor> entities;
    private final InteractionListener listener;


    EntityListAdapter(List<EntityConstructor> entities, InteractionListener listener) {
        this.entities = new ArrayList<> ( entities );
        this.listener = listener;
    }

    @NonNull
    @Override
    public EntityItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemEntityBinding binding = ItemEntityBinding.inflate ( LayoutInflater.from
                        ( parent.getContext () ),
                parent, false );
        return new EntityItemHolder ( binding, listener );
    }

    @Override
    public void onBindViewHolder(@NonNull EntityItemHolder holder, int position) {
        holder.bind ( entities.get ( position ) );
    }

    @Override
    public int getItemCount() {
        return entities.size ();
    }

    public interface InteractionListener {//определили интерфей для взаимодействия данных и экрана (view)

        void onItemShotClickListener(EntityConstructor entityConstructor);

        void onItemLongClickListener(EntityConstructor entityConstructor, View anchor);

    }

}
