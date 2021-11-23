package com.android.androidandjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private DossierEntity dossier = null;//созданна переменная конструктора

    private EditText nameEt;
    private EditText surnameEt;
    private EditText emailEt;

    public ProfileFragment(DossierEntity dossierEntity) {//создали конструктор в классе и присвоили данные конструктора DossierEntity
        dossier = dossierEntity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate ( R.layout.fragment_profile, null );// обратились к фрагменту (создали фрагмент)
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        // инициализировали EditText
        nameEt = view.findViewById ( R.id.name_edit_text );
        surnameEt = view.findViewById ( R.id.surname_edit_text );
        emailEt = view.findViewById ( R.id.email_edit_text );

        // положили EditText в данные
        nameEt.setText ( dossier.name );
        surnameEt.setText ( dossier.surname );
        emailEt.setText ( dossier.email );
    }
}
