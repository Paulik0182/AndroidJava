package com.android.androidandjava;
/*
Данный интерфейс описывает контракт, а именно два вида нажатия Shot и Long.
Далее это нажатие необходимо реализовать в class EntityListAdapter.

Интерфейсом нельзя создать объект, но передать можно. Можно передавать элементы которые сделаны поразному
(выполняют одно и тоже действие), но у них может быть разная реализация.
Обеспечивается единообразная работа с разными источниками данных.
 */

import android.view.View;

public interface OnItemInteractionListener {

    void onItemShotClickListener(EntityConstructor entityConstructor);

    void onItemLongClickListener(EntityConstructor entityConstructor, View anchor);// anchor - это элемент в меню на который мы нажимаем

}