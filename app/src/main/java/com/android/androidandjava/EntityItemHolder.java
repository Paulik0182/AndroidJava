package com.android.androidandjava;

import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;

public class EntityItemHolder extends RecyclerView.ViewHolder {

    private final ItemEntityBinding binding;
    private EntityConstructor entityConstructor;

    public EntityItemHolder(ItemEntityBinding binding) {
        super ( binding.getRoot () );
        this.binding = binding;
    }

    //Связываем два поля указанные в конструкторе
    //на вход функции принемается сущность (модель) и привязываем эту модель к разметке
    //возможна любая комбинация, количество полей.
    //для каждой разметки может быть свая комбинация, набор полей.
    public void bind(EntityConstructor entityConstructor) {
        this.entityConstructor = entityConstructor;
        binding.titleTextView.setText ( entityConstructor.getTitle () );
        binding.detailTextView.setText ( entityConstructor.getDetail () );
    }
}
