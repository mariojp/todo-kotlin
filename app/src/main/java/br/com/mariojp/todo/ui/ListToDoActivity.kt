package br.com.mariojp.todo.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.mariojp.todo.R
import br.com.mariojp.todo.databinding.ActivityListTodoBinding

class ListToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityListTodoId.setText("1")

        binding.activityListTodoTitle.setText("Estudar kotlin")

        binding.activityListTodoDescription.setText("Estudar kotlin para Mobile")

    }
}