package com.android.androidandjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.androidandjava.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    private static final String ARG_PARAM_MESSAGE = "ARG_PARAM_MESSAGE"; //ключ

    private String message;

    public DetailFragment() { //конструктор. Он не доступен. Переопределять его нельзя потому что его использует система
        //Если конструктор переопределить, то система не сможет работать, ей нужен пустой конструктор
    }

    //метод для передачи сообщений, по аналогии с активити.
    public static DetailFragment newInstance(@NonNull String message) {
        DetailFragment fragment = new DetailFragment ();
        Bundle args = new Bundle ();
        args.putString ( ARG_PARAM_MESSAGE, message );
        fragment.setArguments ( args );
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        if (getArguments () != null) {
            this.message = getArguments ().getString ( ARG_PARAM_MESSAGE );
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return FragmentDetailBinding.inflate ( inflater, container, false ).getRoot ();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated ( view, savedInstanceState );
        binding = FragmentDetailBinding.bind ( view ); //!!!!  binding инициализируем именно в этом методе. при уничтожении фрагмента binding зануляем.
        binding.detailFragmentTextView.setText ( message );
    }

    @Override
    public void onDestroyView() {
        binding = null;  //!!!!!! binding обязательно нужно занулить!!!!
        super.onDestroyView ();
    }

}
