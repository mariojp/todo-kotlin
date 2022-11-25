package br.com.mariojp.todo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mariojp.todo.data.ToDoDatabase
import br.com.mariojp.todo.databinding.ActivityListTodoBinding

class ListToDoActivity : AppCompatActivity() {

    private val adapter = ListToDoAdapter(context = this)
    private val binding by lazy {
        ActivityListTodoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        val db = ToDoDatabase.instancia(this)
        val toDoItemDao = db.toDoItemDao()
        adapter.update(toDoItemDao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityListTodoFab
        fab.setOnClickListener {
            vaiParaFormulario()
        }
    }

    private fun vaiParaFormulario() {
        val intent = Intent(this, FormularioActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListTodolist
        recyclerView.adapter = adapter

    }

}