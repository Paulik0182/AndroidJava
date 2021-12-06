package com.android.androidandjava;

import androidx.recyclerview.widget.RecyclerView;

import com.android.androidandjava.databinding.ItemEntityBinding;


public class EntityItemHolder extends RecyclerView.ViewHolder {

    private final ItemEntityBinding binding;
    private Entity entity;


    public EntityItemHolder(ItemEntityBinding binding, EntityListAdapter.InteractionListener listener) {
        super ( binding.getRoot () );

        this.binding = binding;

        itemView.setOnClickListener ( v -> {
            listener.onItemShotClickListener ( entity );
        } );

        itemView.setOnLongClickListener ( v -> {
            listener.onItemLongClickListener ( entity, v );
            return true;
        } );
    }

    public void bind(Entity entity) {
        this.entity = entity;
        binding.titleTextView.setText ( entity.getTitle () );
        binding.detailTextView.setText ( entity.getDetail () );
    }

}
