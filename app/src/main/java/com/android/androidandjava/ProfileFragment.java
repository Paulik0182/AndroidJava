package com.android.androidandjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    public static final String DOSSIER_ARGS_KEY = "DOSSIER_ARGS_KEY";
    private static final String TAG = "@@@ ProfileFragment";// константа для лога

    private DossierEntity dossier = null;//созданна переменная конструктора

    private EditText nameEt;
    private EditText surnameEt;
    private EditText emailEt;
    private Button saveButton;

    //положили данные в аргумент
    public static ProfileFragment newInstance(DossierEntity dossierEntity) {
        ProfileFragment profileFragment = new ProfileFragment ();
        Bundle args = new Bundle ();

        args.putParcelable ( DOSSIER_ARGS_KEY, dossierEntity );

        profileFragment.setArguments ( args );
        return profileFragment;
    }


//    public ProfileFragment(DossierEntity dossierEntity) {//создали конструктор в классе и присвоили данные конструктора DossierEntity
//        dossier = dossierEntity;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
    }

    @Override
    public void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d ( TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]" );
        View view = inflater.inflate ( R.layout.fragment_profile, null );// обратились к фрагменту (создали фрагмент)

        saveButton = view.findViewById ( R.id.save_button );

        saveButton.setOnClickListener ( v -> {
            // ((MainActivity)getActivity ()).resultTextView.setText ( "Привет" ); //так делать никогда нельзя!!!!!
            ProfileController controller = (ProfileController) getActivity ();
            assert controller != null;
            controller.saveResult ( new DossierEntity (
                    nameEt.getText ().toString (),
                    surnameEt.getText ().toString (),
                    emailEt.getText ().toString ()
            ) );
        } );
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d ( TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]" );

        // инициализировали EditText
        nameEt = view.findViewById ( R.id.name_edit_text );
        surnameEt = view.findViewById ( R.id.surname_edit_text );
        emailEt = view.findViewById ( R.id.email_edit_text );

        // положили EditText в данные. dossier это наша созданная переменная с помощью конструктора в данном классе
        nameEt.setText ( dossier.name );
        surnameEt.setText ( dossier.surname );
        emailEt.setText ( dossier.email );
    }

    @Override
    public void onDestroyView() {
        Log.d ( TAG, "onDestroyView() called" );
        super.onDestroyView ();
    }

    @Override
    public void onStart() {
        Log.d ( TAG, "onStart() called" );
        super.onStart ();
    }

    @Override
    public void onResume() {
        Log.d ( TAG, "onResume() called" );
        super.onResume ();
    }

    @Override
    public void onPause() {
        Log.d ( TAG, "onPause() called" );
        super.onPause ();
    }

    @Override
    public void onStop() {
        Log.d ( TAG, "onStop() called" );
        super.onStop ();
    }

    @Override
    public void onAttach(Context context) {
        Log.d ( TAG, "onAttach() called with: context = [" + context + "]" );
        super.onAttach ( context );
        if (!(context instanceof ProfileController)) {
            throw new RuntimeException ( "Activity must implement ProfileController" );
        }

        if (getArguments () != null) {
            dossier = getArguments ().getParcelable ( DOSSIER_ARGS_KEY );
        }
    }

    @Override
    public void onDetach() {
        Log.d ( TAG, "onDetach() called" );
        super.onDetach ();
    }
}
