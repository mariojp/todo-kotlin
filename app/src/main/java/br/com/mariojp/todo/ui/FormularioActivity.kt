package br.com.mariojp.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
            if(this::item.isInitialized) {
                val itemNew = ToDoItem(
                    this.item.id,
                    binding.activityFormularioTitle.text.toString(),
                    binding.activityFormularioDescription.text.toString(),
                )
                toDoItemDao.update(itemNew)
            }else {
                val itemNew = ToDoItem(
                    0,
                    binding.activityFormularioTitle.text.toString(),
                    binding.activityFormularioDescription.text.toString(),)
                toDoItemDao.adiciona(itemNew)
            }
            finish()
        }
    }


}