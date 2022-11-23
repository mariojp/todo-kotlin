package br.com.mariojp.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.ActivityListTodoBinding

class ListToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityListTodolist.adapter =
            ListToDoAdapter(this, arrayListOf( ToDoItem(1, "Titulo 1", "Descricao 1"),
                ToDoItem(2, "Titulo 2", "Descricao 2"),))


    }
}