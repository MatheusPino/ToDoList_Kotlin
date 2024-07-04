package com.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText

class CadastrarFragment : Fragment() {
    private lateinit var titulo : EditText
    private lateinit var descricao : EditText
    private lateinit var data : DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastrar, container, false)
        data = view.findViewById(R.id.dataCadastrarTarefa)
        descricao = view.findViewById(R.id.DescricaoCadastrarTarefa)
        titulo = view.findViewById(R.id.TituloCadastrarTarefa)

        return view
    }

    companion object {


    }
}