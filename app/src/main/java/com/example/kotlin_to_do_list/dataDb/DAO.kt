package com.example.kotlin_to_do_list.dataDb

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlin_to_do_list.model.Entity

@Dao
interface DAO{

    @Query("SELECT * FROM Entity1 ORDER BY id ASC")
    fun getTodoList(): LiveData<List<Entity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveTodo(entity: Entity)

    @Update
    fun updateTodo(entity: Entity)

    @Delete
    fun removeTodo(entity: Entity)

    @Query("DELETE FROM Entity1")
    suspend fun deleteAllTodo()
}

