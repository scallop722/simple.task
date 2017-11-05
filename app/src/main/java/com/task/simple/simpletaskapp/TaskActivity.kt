package com.task.simple.simpletaskapp

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.task.simple.simpletaskapp.model.Task
import com.task.simple.simpletaskapp.view.TaskView

/**
 * Created by scallop316 on 2017/11/04.
 */

class TaskActivity : AppCompatActivity() {

    companion object {

        private const val TASK_EXTRA: String = "task"

        fun intent(context: Context, task: Task): Intent =
                Intent(context, TaskActivity::class.java)
                        .putExtra(TASK_EXTRA, task)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val taskView: TaskView = findViewById(R.id.task_view)

        val task: Task = intent.getParcelableExtra(TASK_EXTRA)
        taskView.setTask(task)

        val deleteButton: Button = findViewById(R.id.delete_button)
        deleteButton.setOnClickListener {

            val helper = MySQLiteOpenHelper(this)
            val db: SQLiteDatabase = helper.readableDatabase

            val where: String = "_id = ?"

            try {
                db.delete("task", where, arrayOf(task.id.toString()))
            } finally {
                db.close()
            }

            MainActivity.intent(this).let { startActivity(it) }
        }
    }
}