package br.com.mariojp.todo.data

import java.util.concurrent.atomic.AtomicLong

class ToDoItemDao {

    fun adiciona(toDoItem: ToDoItem) {
        toDoItem.id = index.incrementAndGet()
        horarios.add(toDoItem)
    }

    fun remove(toDoItem: ToDoItem) {
        horarios.remove(toDoItem)
    }

    fun buscaTodos(): List<ToDoItem> {
        return horarios.toList()
    }

    companion object {
        private val index = AtomicLong(0)
        private val horarios = mutableListOf<ToDoItem>(
            ToDoItem(
                1, "Titulo 1", "Descricao 1"
            )
        )
    }

}