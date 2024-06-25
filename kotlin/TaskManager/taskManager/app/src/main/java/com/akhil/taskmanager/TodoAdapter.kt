package com.akhil.taskmanager

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter (private val context: Context, private val todos:List<String>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){

    inner class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val todoTextTitle:TextView = itemView.findViewById(R.id.todoItemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_recycler_view_item, parent, false)
        return  TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todos[position]
        holder.todoTextTitle.text = todo
        holder.todoTextTitle.setOnClickListener {
            val intent = Intent(context, TodoDetailActivity::class.java)
            intent.putExtra(TODO_TITLE, todo)
            context.startActivity(intent)
        }
    }

    companion object {
        const val TODO_TITLE = "TODO_TITLE"
    }

}