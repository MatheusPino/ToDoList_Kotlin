package com.todolist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.todolist.R
import com.todolist.model.Tarefa
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class TarefaAdapter(private val context: Context, private val tarefas: List<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TarefaViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.tituloTextView.text = tarefa.titulo

        val diasRestantes = calcularDiasRestantes(tarefa.data)
        holder.diasRestantesTextView.text = "$diasRestantes"

        val backgroundResource = if (Date().after(converterStringParaData(tarefa.data))) {
            R.drawable.border_red
        } else {
            R.drawable.border_green
        }
        holder.itemView.setBackgroundResource(backgroundResource)
    }

    private fun calcularDiasRestantes(data: String): Long {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val data: Date = dateFormat.parse(data)
        val diferenca = data.time - Date().time
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS)
    }

    private fun converterStringParaData(data: String): Date {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.parse(data)
    }

    override fun onBindViewHolder(
        holder: TarefaViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }

    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
        val diasRestantesTextView: TextView = itemView.findViewById(R.id.diasRestantesTextView)
    }

}