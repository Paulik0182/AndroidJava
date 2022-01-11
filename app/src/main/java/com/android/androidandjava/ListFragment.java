package com.android.androidandjava;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.androidandjava.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private Contract contract;

    private static final String TAG = "@@@ ListFragment";
    private FragmentListBinding binding;

    @Override
    public void onAttach(@NonNull Context context) {//в основном используется для того, чтобы призентер присоединить к фрагменту (при MMVP)
        Log.d ( TAG, "onAttach() called with: context = [" + context + "]" );
        if (context instanceof Contract) {
            contract = (Contract) context;//реализуется метод
        } else {
            //если не реализуется метод, контракт, то выдается исключение
            throw new IllegalStateException ( "Activity not implemented contract" );
        }
        super.onAttach ( context );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]" );
        super.onViewCreated ( view, savedInstanceState );
        binding = FragmentListBinding.bind ( view );    //!!!!  binding инициализируем именно в этом методе. при уничтожении фрагмента binding зануляем.

        binding.launchDetailFragmentButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки, вызываем второй фрагмент
                contract.showDetail ( binding.messageEditText.getText ().toString () );
            }
        } );

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
    }

    //у фрагмента несколько стадий создания. Поэтому несколько методов onCreate. Соответственно и несколько onDestroy
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]" );
        //раздувается view на основе созданного макета и корень этой view передается дальше этой системе
        return FragmentListBinding.inflate ( inflater, container, false ).getRoot ();
        //в данном методе можно инициализировать binding, но при этом нужно будет проверять view, не является ли она нулем.
        //лучше binding инициализировать в методе onViewCreated, там проверка на ноль не нужна.
    }

    //при выполнении этого метода, эначит фрагмент уничтожен полностью.
    @Override
    public void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        contract = null;//контракт существует пока существует фрагмент. контракт обязательно зануляем
        super.onDestroy ();
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

    //интерфейс определяет метод которая должно реализовать активити
    //активити выступает в качестве контроллера, она знает о фрагментах, но фрагменты не знают о друг другах и об активити поэтому и вводится контракт
    //в методе onAttach происходит установка котракта
    //в активити имплементируем контракт, там же его реализуем , метод showDetail
    interface Contract {
        void showDetail(String message);
    }

}
