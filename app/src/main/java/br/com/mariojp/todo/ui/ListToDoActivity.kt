package br.com.mariojp.todo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.mariojp.todo.R

class ListToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_todo)
        val id = findViewById<TextView>(R.id.activity_list_todo_id)
        id.setText("1")
        val title = findViewById<TextView>(R.id.activity_list_todo_title)
        title.setText("Estudar kotlin")
        val description = findViewById<TextView>(R.id.activity_list_todo_description)
        description.setText("EStudar kotlin para Mobile")

    }
}