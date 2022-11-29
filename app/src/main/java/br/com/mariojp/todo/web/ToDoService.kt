package br.com.mariojp.todo.web

import br.com.mariojp.todo.data.ToDoItem
import retrofit2.Call
import retrofit2.http.GET

interface ToDoService {

    @GET("mariojp/todo-kotlin/json/todos.json")
    suspend fun buscaTodas(): List<ToDoResposta>
}