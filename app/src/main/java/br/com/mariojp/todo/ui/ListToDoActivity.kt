package br.com.mariojp.todo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.data.ToDoItemDao
import br.com.mariojp.todo.databinding.ActivityListTodoBinding

class ListToDoActivity : AppCompatActivity() {

    private val dao = ToDoItemDao()
    private val adapter = ListToDoAdapter(context = this, dao.buscaTodos())
    private val binding by lazy {
        ActivityListTodoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraFab()
        configuraRecyclerView()
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

    override fun onResume() {
        super.onResume()
        adapter.update(dao.buscaTodos())
    }
}