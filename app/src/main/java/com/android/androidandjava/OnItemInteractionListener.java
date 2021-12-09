package com.android.androidandjava;
/*
Данный интерфейс описывает контракт, а именно два вида нажатия Shot и Long.
Далее это нажатие необходимо реализовать в class EntityListAdapter
 */

public interface OnItemInteractionListener {

    void onItemShotClickListener(EntityConstructor entityConstructor);

    void onItemLongClickListener(EntityConstructor entityConstructor);

}