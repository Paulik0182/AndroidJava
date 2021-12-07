package com.android.androidandjava;

import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;


public class EntityItemHolder extends RecyclerView.ViewHolder {

    private final ItemEntityBinding binding;
    private EntityConstructor entityConstructor;


    public EntityItemHolder(ItemEntityBinding binding, EntityListAdapter.InteractionListener listener) {
        super ( binding.getRoot () );

        this.binding = binding;

        itemView.setOnClickListener ( v -> {//обработка нажатия на item
            listener.onItemShotClickListener ( entityConstructor );
        } );

        itemView.setOnLongClickListener ( v -> {//обработка нажатия на item
            listener.onItemLongClickListener ( entityConstructor, v );
            return true;
        } );
    }

    public void bind(EntityConstructor entityConstructor) {//связывает поля конструктора (выводится во view единым текстом все или несколько полей конструктора)
        this.entityConstructor = entityConstructor;//обращение к конструктору. там структура данных, поля
        binding.titleTextView.setText ( entityConstructor.getTitle () );//получаем по id доступ к TextView в Layout item_entity
        binding.detailTextView.setText ( entityConstructor.getDetail () );//получаем по id доступ к TextView в Layout item_entity
    }

}
