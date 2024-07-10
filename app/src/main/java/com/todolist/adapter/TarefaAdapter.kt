package com.todolist.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todolist.model.Tarefa

class TarefaAdapter(private val context: Context, private val tarefas: List<Tarefa> ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TarefaAdapter.TarefaViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TarefaAdapter.TarefaViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: TarefaAdapter.TarefaViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class TarefaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

}