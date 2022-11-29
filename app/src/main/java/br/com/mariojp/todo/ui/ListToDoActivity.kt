package br.com.mariojp.todo.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

import br.com.mariojp.todo.data.ToDoDatabase
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.ActivityListTodoBinding
import br.com.mariojp.todo.web.RetrofitFabrica
import br.com.mariojp.todo.web.WebClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListToDoActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListToDoAdapter(this)
    }

    private val dao by lazy {
        ToDoDatabase.instancia(this).toDoItemDao()
    }

    private val binding by lazy {
        ActivityListTodoBinding.inflate(layoutInflater)
    }

    private val webclient by lazy {
        WebClient()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()

        lifecycleScope.launch {
            val dados = webclient.buscaTodas()
            dados?.let { todos ->
                dao.adicionaAll(todos)
            }
            Log.i("ListaNotas", "onCreate: retrofit coroutines $dados")
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                buscaTodos()
            }
        }





    }

    private fun buscaTodos() {
        adapter.update(dao.buscaTodos())
    }

    override fun onResume() {
        super.onResume()
//        adapter.update(dao.buscaTodos())
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
        adapter.eventoClick = { item ->
            Log.i("ListaProdutosActivity", "quandoClica: ${item.title}")
            val intent = Intent(this, FormularioActivity::class.java).apply {
                putExtra("ITEM",item)
            }
            startActivity(intent)
        }
    }

}