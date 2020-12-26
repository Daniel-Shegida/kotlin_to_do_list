package com.example.kotlin_to_do_list.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_to_do_list.dataDb.DAO
import com.example.kotlin_to_do_list.model.Entity

class ListRepository(private val dao: DAO) {

    val readAllData: LiveData<List<Entity>> = dao.getTodoList()

    suspend fun addTodo(todo: Entity){
        dao.saveTodo(todo)
    }

    suspend fun deleteTodo(todo: Entity){
        dao.removeTodo(todo)
    }

    suspend fun deleteAllTodo(){
        dao.deleteAllTodo()
    }
}