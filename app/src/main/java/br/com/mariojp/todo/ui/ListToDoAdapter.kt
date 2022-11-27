package br.com.mariojp.todo.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.TodoItemBinding

class ListToDoAdapter(
    private val context: Context,
    todos : List<ToDoItem> = emptyList(),
    var eventoClick: (todo: ToDoItem) -> Unit = {}
) : RecyclerView.Adapter<ListToDoAdapter.ViewHolder>() {

    private val todos = todos.toMutableList()

    inner class ViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var toDoItem: ToDoItem

        init {
            itemView.setOnClickListener{
                Log.i("Adapter", "click no item")
                if(::toDoItem.isInitialized) {
                    eventoClick(toDoItem)
                }
            }
        }

        fun bind(todoItem : ToDoItem){
            this.toDoItem = todoItem;
            binding.activityListTodoId.text = todoItem.id.toString()
            binding.activityListTodoTitle.text = todoItem.title
            binding.activityListTodoDescription.text = todoItem.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = TodoItemBinding.inflate(inflater,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size


    fun update(todos: List<ToDoItem>) {
        this.todos.clear()
        this.todos.addAll(todos)
        notifyDataSetChanged()
    }
}