package com.android.androidandjava;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;

public class EntityItemHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "@@@EntityItemHolder";

    private final ItemEntityBinding binding;
    private EntityConstructor entityConstructor;

    public EntityItemHolder(ItemEntityBinding binding, OnItemInteractionListener listener) {
        super ( binding.getRoot () );
        this.binding = binding;

        //реализация короткого нажатия на текст
        itemView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                listener.onItemShotClickListener ( entityConstructor );
                Log.d ( TAG, "onClick: Shot" );
            }
        } );

        //реализация длинного нажатия на текст (можно использовать для контекстных действий, например, для вызова меню)
        itemView.setOnLongClickListener ( new View.OnLongClickListener () {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClickListener ( entityConstructor, v );
                Log.d ( TAG, "onLongClick" );
                return true;
            }
        } );
    }

    //Связываем два поля указанные в конструкторе
    //на вход функции принемается сущность (модель) и привязываем эту модель к разметке
    //возможна любая комбинация, количество полей.
    //для каждой разметки может быть свая комбинация, набор полей.
    public void bind(EntityConstructor entityConstructor) {
        this.entityConstructor = entityConstructor;
        binding.titleTextView.setText ( entityConstructor.getTitle () );
        binding.detailTextView.setText ( entityConstructor.getDetail () );
        Log.d ( TAG, "bind(): entityConstructor = [" + entityConstructor + "]" );
    }
}
