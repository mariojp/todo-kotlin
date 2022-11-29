package br.com.mariojp.todo.web

import br.com.mariojp.todo.data.ToDoItem

data class ToDoResposta(
    val id: String?,
    val title : String?,
    val description: String?
){
    val toDoItem: ToDoItem get() = ToDoItem(
        id = 0,
        title = title ?: "",
        description = description ?: "",
    )

}
