package com.todolist.repository

import com.todolist.Tarefa

interface IRepository {
    fun salvar(key: String, tarefa: Tarefa): Boolean
    fun obter(key: String): Tarefa

}