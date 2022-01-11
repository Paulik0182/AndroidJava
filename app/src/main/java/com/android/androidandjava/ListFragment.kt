package com.android.androidandjava

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.androidandjava.databinding.FragmentListBinding

class ListFragment : Fragment() {

    //во фрагменте запись binding сложней. С начало мы используем null переменную,
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!! //а потом описываем не null переменную


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListBinding.inflate(inflater, container, false).root

    //или может быть такая запись. Сначало инициализируем null переменную, а потом везде используем не null переменную
//    ): View = FragmentListBinding.inflate(inflater, container, false).also { binding->
//        _binding = binding//инициализируем null переменную
//    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view) //инициализируем null переменную

        //пример использования не null переменной
//        binding.textHome.text = message
    }

    override fun onDestroyView() {
        _binding =
            null //В связи с тем, что _binding живет меньше чем фрагмент его обязательно нужно занулять, для предотвращения утечки памяти
        super.onDestroyView()
    }

}