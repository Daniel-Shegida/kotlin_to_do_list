package com.example.kotlin_to_do_list.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlin_to_do_list.dataDb.AbstactDatabase
import com.example.kotlin_to_do_list.model.Entity
import com.example.kotlin_to_do_list.repository.ListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Entity>>
    private val repository: ListRepository

    init {
        val todoDao = AbstactDatabase.getDatabase(application).getTodoDao()
        repository = ListRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addTodo(todo: Entity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTodo(todo)
        }
    }

    fun deleteTodo(todo: Entity){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteTodo(todo)
        }
    }

    fun deleteALLTodo(){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteAllTodo()
        }
    }
}