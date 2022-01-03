package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;

import java.util.ArrayList;
import java.util.List;

public class EntityListAdapter extends RecyclerView.Adapter<EntityItemHolder> {

    private static final String TAG = "@@@EntityListAdapter";

    private ArrayList<EntityConstructor> entities; //определили список наших сущьностей
    private final OnItemInteractionListener listener;//слушатель

    //вместе со списком entities, передаем объект listener
    @SuppressLint("NotifyDataSetChanged")
    EntityListAdapter(List<EntityConstructor> entities, OnItemInteractionListener listener) {
        this.entities = new ArrayList<> ( entities );
        this.listener = listener;
        Log.d ( TAG, "EntityListAdapter: entities = [" + entities + "], listener = [" + listener + "]" );
    }

    @NonNull
    @Override
    public EntityItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d ( TAG, "onCreateViewHolder: parent = [" + parent + "], viewType = [" + viewType + "]" );
        //для возможности использовать binding
        ItemEntityBinding binding = ItemEntityBinding.inflate ( LayoutInflater.from ( parent.getContext () ),
                parent,
                false );
        return new EntityItemHolder ( binding, listener );
    }

    @Override
    public void onBindViewHolder(@NonNull EntityItemHolder holder, int position) {
        Log.d ( TAG, "onBindViewHolder: holder = [" + holder + "], position = [" + position + "]" );
        holder.bind ( entities.get ( position ) );//свызываем элементы списка (entities). Счетчик - position, счетчик необходим для класса RecyclerView
    }

    @Override
    public int getItemCount() {
        Log.d ( TAG, "getItemCount: size" );
        return entities.size ();//Возвращаем количество элементов в списк (size)
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<EntityConstructor> entities) {// метод для обновления списка
        this.entities = new ArrayList<> ( entities );
//        notifyDataSetChanged ();
    }
}
//Вышеуказанные три метода необходимо переопределить обязательно
//в данном примере сделаны два вспомогательных класса для обеспечения RecyclerView