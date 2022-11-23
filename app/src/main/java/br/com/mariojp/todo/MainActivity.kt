package br.com.mariojp.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val id = findViewById<TextView>(R.id.id)
        id.setText("1")
        val title = findViewById<TextView>(R.id.title)
        title.setText("Estudar kotlin")
        val description = findViewById<TextView>(R.id.description)
        description.setText("EStudar kotlin para Mobile")

    }
}