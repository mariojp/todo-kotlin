package br.com.mariojp.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mariojp.todo.R
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.data.ToDoItemDao
import br.com.mariojp.todo.databinding.ActivityFormularioBinding
import br.com.mariojp.todo.databinding.ActivityListTodoBinding

class FormularioActivity : AppCompatActivity() {

    private val dao = ToDoItemDao()

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.activityFormularioSalvar.setOnClickListener {
            val todoItem = ToDoItem(0,
                binding.activityFormularioTitle.text.toString(),
                binding.activityFormularioDescription.text.toString(),
            )
            dao.adiciona(todoItem)
            finish()
        }

    }





}