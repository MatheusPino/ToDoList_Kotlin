package com.todolist.view

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.todolist.R
import com.todolist.model.Tarefa
import com.todolist.repository.IRepository
import com.todolist.repository.RepositoryImpl
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CadastrarFragment : Fragment() {
    private lateinit var titulo: TextInputEditText
    private lateinit var descricao: TextInputEditText
    private lateinit var data: TextInputEditText
    private lateinit var button: Button
    private val calendario = Calendar.getInstance()
    private lateinit var repository: IRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cadastrar, container, false)
        data = view.findViewById(R.id.inputData)
        descricao = view.findViewById(R.id.inputDescricao)
        titulo = view.findViewById(R.id.inputTitulo)
        button = view.findViewById(R.id.botaoSalvarForm)

        data.setOnClickListener {
            mostrarCalendario()
        }
        button.setOnClickListener {
            salvarForm()
        }
        repository = RepositoryImpl(
            sharedPreference = requireContext().getSharedPreferences(
                "lista_tarefas",
                Context.MODE_PRIVATE
            )
        )
        return view
    }

    fun mostrarCalendario() {
        val dataSetListener = DatePickerDialog.OnDateSetListener { _, ano, mes, dia ->
            calendario.set(Calendar.YEAR, ano)
            calendario.set(Calendar.MONTH, mes)
            calendario.set(Calendar.DAY_OF_MONTH, dia)
            atualizarCampoData()
        }
        DatePickerDialog(
            requireContext(),
            dataSetListener,
            calendario.get(Calendar.YEAR),
            calendario.get(Calendar.MONTH),
            calendario.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    fun atualizarCampoData() {
        val formato = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(formato, Locale.US)
        data.setText(dateFormat.format(calendario.time))
    }

    fun salvarForm() {
        val tarefa = Tarefa(
            titulo = titulo.text.toString(),
            descricao = descricao.text.toString(),
            data = data.text.toString()
        )
        val result = repository.salvar(key = tarefa.titulo, tarefa)
        val navController = activity?.findNavController(R.id.nav_host_fragment_content_main)
        if (result) navController?.navigate(R.id.ListarFragment)
    }
}