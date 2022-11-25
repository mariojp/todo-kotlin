package br.com.mariojp.todo.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title : String,
    val description: String

    )
