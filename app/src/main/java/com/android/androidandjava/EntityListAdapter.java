package com.android.androidandjava;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;

import java.util.ArrayList;
import java.util.List;

public class EntityListAdapter extends RecyclerView.Adapter<EntityItemHolder> {

    private final ArrayList<EntityConstructor> entities; //определили список наших сущьностей

    EntityListAdapter(List<EntityConstructor> entities) {
        this.entities = new ArrayList<> ( entities );
    }

    @NonNull
    @Override
    public EntityItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //для возможности использовать binding
        ItemEntityBinding binding = ItemEntityBinding.inflate ( LayoutInflater.from ( parent.getContext () ),
                parent,
                false );
        return new EntityItemHolder ( binding );
    }

    @Override
    public void onBindViewHolder(@NonNull EntityItemHolder holder, int position) {
        holder.bind ( entities.get ( position ) );//свызываем элементы списка (entities). Счетчик - position, счетчик необходим для класса RecyclerView
    }

    @Override
    public int getItemCount() {
        return entities.size ();//Возвращаем количество элементов в списк (size)
    }
}
//Вышеуказанные три метода необходимо переопределить обязательно
//в данном примере сделаны два вспомогательных класса для обеспечения RecyclerView