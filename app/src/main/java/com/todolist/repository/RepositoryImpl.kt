package com.todolist.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.todolist.model.Tarefa

class RepositoryImpl : IRepository {
    private val sharedPreference: SharedPreferences
    private val gson = Gson()

    constructor(sharedPreference: SharedPreferences) {
        this.sharedPreference = sharedPreference
    }

    override fun salvar(key: String, tarefa: Tarefa): Boolean {
        val elementoDuplicado = sharedPreference.getString(key, null)
        if(elementoDuplicado == null){
            val dado = gson.toJson(tarefa)
            this.sharedPreference.edit().putString(key, dado).apply()
            return dado.isNotBlank()
        }
        return false
    }

    override fun obter(key: String): Tarefa {
        TODO("Not yet implemented")
    }

    override fun obterTodasTarefas(): List<Tarefa> {
        return this.sharedPreference.all.values.map { json ->
            gson.fromJson(
                json as String,
                Tarefa::class.java
            )
        }
    }
}