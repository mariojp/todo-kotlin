package br.com.mariojp.todo.web

import br.com.mariojp.todo.data.ToDoItem
import retrofit2.Call
import retrofit2.await

class WebClient {


    suspend fun buscaTodas(): List<ToDoItem>?  {
        return try {
            val items = RetrofitFabrica().toDoService.buscaTodas()
            items.map { item ->
                item.toDoItem
            }
        } catch (e: Exception) {
            null
        }
    }
}