package br.com.mariojp.todo.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.mariojp.todo.R
import br.com.mariojp.todo.data.ToDoDatabase
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.ActivityFormularioBinding


class FormularioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioBinding.inflate(layoutInflater)
    }

    private lateinit var item: ToDoItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Log.d("FormularioActivity", "Chamou")
        configuraBotaoSalvar()
        carregarItemParaEdicao()

    }

    private fun carregarItemParaEdicao() {
        // tentativa de buscar o produto se ele existir,
        // caso contrário, finalizar a Activity
        intent.getParcelableExtra<ToDoItem>("ITEM") ?.let { item ->
            this.item = item
            preencheCampos(item)
        }
    }

    private fun preencheCampos(item:  ToDoItem) {
        with(binding) {
            activityFormularioTitle.setText( item.title)
            activityFormularioDescription.setText(item.description)
        }
    }

    private fun configuraBotaoSalvar() {
        binding.activityFormularioSalvar.setOnClickListener {
            val db = ToDoDatabase.instancia(this)
            val toDoItemDao = db.toDoItemDao()
            var id : Long = 0
            if(this::item.isInitialized) {
                id = this.item.id
            }
            val itemNew = ToDoItem(
                id,
                binding.activityFormularioTitle.text.toString(),
                binding.activityFormularioDescription.text.toString(),
            )
            toDoItemDao.adiciona(itemNew)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        if(this::item.isInitialized) {
            menu!!.findItem(R.id.menu_item_remover).isVisible = true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_item_remover -> {
                val db = ToDoDatabase.instancia(this)
                val toDoItemDao = db.toDoItemDao()
                toDoItemDao.remove(this.item)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}