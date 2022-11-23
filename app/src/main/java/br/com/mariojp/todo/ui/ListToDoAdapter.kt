package br.com.mariojp.todo.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.mariojp.todo.data.ToDoItem
import br.com.mariojp.todo.databinding.TodoItemBinding

class ListToDoAdapter(
    private val context: Context,
    private val todos : List<ToDoItem>,
) : RecyclerView.Adapter<ListToDoAdapter.ViewHolder>() {

    class ViewHolder(private val view: TodoItemBinding) : RecyclerView.ViewHolder(view.root) {

        fun bind(todoItem : ToDoItem){
            view.activityListTodoId.text = todoItem.id.toString()
            view.activityListTodoTitle.text = todoItem.title
            view.activityListTodoDescription.text = todoItem.description
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

}