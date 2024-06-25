package com.akhil.taskmanager

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addBtn: Button
    private lateinit var todoRecyclerview: RecyclerView
    private lateinit var adapter: TodoAdapter
    private var todoList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText = findViewById(R.id.editText)
        addBtn = findViewById(R.id.addBtn)
        todoRecyclerview = findViewById(R.id.todoRecyclerview)

        adapter = TodoAdapter(this, todoList)
        todoRecyclerview.adapter = adapter
        todoRecyclerview.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener {
            val todoTitle = editText.text.toString()
            if (todoTitle.isNotEmpty()){
                todoList.add(todoTitle)
                adapter.notifyItemInserted(todoList.size -1)
                editText.text.clear()
            }else Toast.makeText(this, "Task field is required",Toast.LENGTH_SHORT).show()

        }

    }
}