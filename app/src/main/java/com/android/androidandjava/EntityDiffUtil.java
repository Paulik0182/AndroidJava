package com.android.androidandjava;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class EntityDiffUtil extends DiffUtil.Callback {//контроль изменений. Используется для определения изменений элементов в списке, долее для прорисовке данные передаются в адаптор

    private final List<EntityConstructor> oldEntities;//список старых значений
    private final List<EntityConstructor> newEntities;//список новых значений


    EntityDiffUtil(List<EntityConstructor> oldEntities, List<EntityConstructor> newEntities) {//передаем списки значений (старый, новый)
        this.oldEntities = oldEntities;
        this.newEntities = newEntities;
    }

    @Override
    public int getOldListSize() {//старый массив данных
        return oldEntities.size ();
    }

    @Override
    public int getNewListSize() {//новый массив данных
        return newEntities.size ();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {//метод проверки элементов (был ли элемент изменен). проверяются айди (uid)
        return oldEntities.get ( oldItemPosition ).getUid ().equals ( newEntities.get ( newItemPosition ).getUid () );
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {//метод проверяет содержимое элементов
        return oldEntities.get ( oldItemPosition ).getTitle ().equals ( newEntities.get ( newItemPosition ).getTitle () )
                && oldEntities.get ( oldItemPosition ).getDetail ().equals ( newEntities.get ( newItemPosition ).getDetail () );
    }
}
