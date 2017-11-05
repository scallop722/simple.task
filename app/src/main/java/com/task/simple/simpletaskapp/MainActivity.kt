package com.task.simple.simpletaskapp

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.task.simple.simpletaskapp.model.Task
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter =  TaskListAdapter(applicationContext)
        listAdapter.tasks = listOf(dummyTask("Kotlin入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"),
                dummyTask("Java入門"))

        val listView: ListView = findViewById(R.id.list_view)
        listView.adapter = listAdapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val task = listAdapter.tasks[position]
            TaskActivity.intent(this, task).let { startActivity(it) }
        }

        val createButton: FloatingActionButton = findViewById(R.id.create_button)
        createButton.setOnClickListener { view ->
            CreateTaskActivity.intent(this).let { startActivity(it) }
        }
    }

    private fun dummyTask(title: String): Task =
            Task(id = "",
                title = title,
                url = "https://kotlinlang.org/")
}