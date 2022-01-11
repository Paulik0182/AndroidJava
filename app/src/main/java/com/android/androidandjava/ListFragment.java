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

import com.android.androidandjava.databinding.FragmentListBinding;

public class ListFragment extends Fragment {

    private static final String TAG = "@@@ ListFragment";
    private FragmentListBinding binding;


    @Override
    public void onAttach(@NonNull Context context) {
        Log.d ( TAG, "onAttach() called with: context = [" + context + "]" );
        super.onAttach ( context );
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]" );
        super.onCreate ( savedInstanceState );
    }

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]" );
        return FragmentListBinding.inflate ( inflater, container, false ).getRoot ();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d ( TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]" );
        super.onViewCreated ( view, savedInstanceState );
        binding = FragmentListBinding.bind ( view );
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
    public void onDestroyView() {
        Log.d ( TAG, "onDestroyView() called" );
        binding = null;
        super.onDestroyView ();
    }

    @Override
    public void onDestroy() {
        Log.d ( TAG, "onDestroy() called" );
        super.onDestroy ();
    }

}
