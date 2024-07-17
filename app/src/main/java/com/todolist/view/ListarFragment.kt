package com.todolist.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.todolist.R
import com.todolist.adapter.TarefaAdapter
import com.todolist.repository.IRepository
import com.todolist.repository.RepositoryImpl

class ListarFragment : Fragment() {

    private lateinit var repository: IRepository
    private lateinit var adapter: TarefaAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository = RepositoryImpl(
            sharedPreference = requireContext().getSharedPreferences(
                "lista_tarefas",
                Context.MODE_PRIVATE
            )
        )
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val tarefas = repository.obterTodasTarefas()

        adapter = TarefaAdapter(requireContext(), tarefas)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listar, container, false)
    }

}