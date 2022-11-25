package br.com.mariojp.todo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 1)
abstract class ToDoDatabase :  RoomDatabase() {
    abstract fun toDoItemDao(): ToDoItemDao

    companion object {
        fun instancia(context: Context) : ToDoDatabase {
            return Room.databaseBuilder(
                context,
                ToDoDatabase::class.java,
                "todos.db"
            ).allowMainThreadQueries()
                .build()
        }
    }
}