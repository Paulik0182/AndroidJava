package com.android.androidandjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.androidandjava.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private static final String TAG = "@@@ ListFragment";
    private FragmentListBinding binding;


    @Override
    public void onAttach(@NonNull Context context) {//в основном используется для того, чтобы призентер присоединить к фрагменту (при MMVP)
        Log.d ( TAG, "onAttach() called with: context = [" + context + "]" );
        super.onAttach ( context );
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
    }

    //у фрагмента несколько стадий создания. Поэтому несколько методов onCreate. Соответственно и несколько onDestroy
    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]" );
        //раздувается view на основе созданного макета и корень этой view передается дальше этой системе
        return FragmentListBinding.inflate ( inflater, container, false ).getRoot ();
        //в данном методе можно инициализировать binding, но при этом нужно будет проверять view, не является ли она нулем.
        //лучше binding инициализировать в методе onViewCreated, там проверка на ноль не нужна.
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]" );
        super.onViewCreated ( view, savedInstanceState );
        binding = FragmentListBinding.bind ( view );    //!!!!  binding инициализируем именно в этом методе. при уничтожении фрагмента binding зануляем.

        binding.launchDetailFragmentButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = requireActivity ().getSupportFragmentManager ();
                fragmentManager.beginTransaction ()
                        .add ( R.id.detail_fragment_container, new DetailFragment () )
                        .addToBackStack ( null )
                        .commit ();
            }
        } );

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

    //при уничтожении фрагмента, его визуальная часть может остоватся, поэтому View уничтожается отдельно.
    @Override
    public void onDestroyView() {
        Log.d ( TAG, "onDestroyView() called" );
        binding = null;                             //!!!!!! binding обязательно нужно занулить!!!!
        super.onDestroyView ();
    }

    //при выполнении этого метода, эначит фрагмент уничтожен полностью.
    @Override
    public void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }

}
