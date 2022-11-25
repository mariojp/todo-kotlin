package br.com.mariojp.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.mariojp.todo.data.ToDoDatabase
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.ActivityFormularioBinding

class FormularioActivity : AppCompatActivity() {

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
            val db = ToDoDatabase.instancia(this)
            val toDoItemDao = db.toDoItemDao()
            toDoItemDao.adiciona(todoItem)
            finish()
        }

    }





}