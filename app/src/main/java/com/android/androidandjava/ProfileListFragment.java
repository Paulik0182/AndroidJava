package com.android.androidandjava;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class ProfileListFragment extends Fragment {

    private final DossierEntity dossier1 = new DossierEntity//задали данные в конструктор. конструктор в DossierEntity. если эту строку положить в обработчик кнопки , будет ошибка
            ( "Pavel", "Bob", "Bob@gmail.com" );
    private final DossierEntity dossier2 = new DossierEntity ( "Иван", "Петрович", "Ip@gmail.com" );
    private final DossierEntity dossier3 = new DossierEntity ( "Сергей", "Иванов", "Si@gmail.com" );
    private final DossierEntity dossier4 = new DossierEntity ( "Дмитрий", "Кошуль", "Dk@gmail.com" );
    private final DossierEntity dossier5 = new DossierEntity ( "Ольга", "Сидорова", "Os@gmail.com" );
    private LinearLayout linearLayout;

    private void addDossierToList(DossierEntity dossierEntity) {
        Button button = new Button ( getContext () );
        button.setText ( dossierEntity.toString () );
        button.setOnClickListener ( v -> {
            ((Controller) getActivity ()).openProfileScreen ( dossierEntity );

        } );
        linearLayout.addView ( button );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate ( R.layout.fragment_profile_list, null );
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach ( context );
        if (!(context instanceof Controller)) {
            throw new RuntimeException ( "Activity must implement ProfileListFragment.Controller" );
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        linearLayout = view.findViewById ( R.id.linear );
        addDossierToList ( dossier1 );
        addDossierToList ( dossier2 );
        addDossierToList ( dossier3 );
        addDossierToList ( dossier4 );
        addDossierToList ( dossier5 );

    }

    interface Controller {
        void openProfileScreen(DossierEntity dossier);
    }
}
