package br.com.mariojp.todo.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoItemDao {

    @Insert
    fun adiciona(toDoItem: ToDoItem)

    @Delete
    fun remove(toDoItem: ToDoItem)

    @Query("SELECT * FROM ToDoItem")
    fun buscaTodos(): List<ToDoItem>



}