package com.todolist.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.todolist.Tarefa

class RepositoryImpl : IRepository {
    private val sharedPreference: SharedPreferences
    private val gson = Gson()

    constructor(sharedPreference: SharedPreferences) {
        this.sharedPreference = sharedPreference
    }

    override fun salvar(key: String, tarefa: Tarefa): Boolean {
        val dado = gson.toJson(tarefa)
        return dado.isNotBlank()
    }

    override fun obter(key: String): Tarefa {
        TODO("Not yet implemented")
    }
}