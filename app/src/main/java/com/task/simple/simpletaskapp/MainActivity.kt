package com.task.simple.simpletaskapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.task.simple.simpletaskapp.model.Task
import com.task.simple.simpletaskapp.model.createUsingCursor

class MainActivity : AppCompatActivity() {


    companion object {

        fun intent(context: Context): Intent =
                Intent(context, MainActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO タスク登録周りが完了次第削除
        // サンプルデータを追加する
//        addSampleColmun()

        val listAdapter = TaskListAdapter(applicationContext)
        // DBにあるタスクを全件取得する
        listAdapter.tasks = findAll()

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

    /**
     * TODO タスク登録周りが完成次第削除
     * サンプルデータをDBに挿入します。
     */
    private fun addSampleColmun() {
        val helper = MySQLiteOpenHelper(this)
        val db: SQLiteDatabase = helper.writableDatabase

        try {
            db.delete("task", null, emptyArray())

//            for (i in 1..10) {
//                val values: ContentValues = ContentValues()
//                values.put("title", "テスト" + i.toString())
//
//                db.insert("task", null, values)
//            }
        } finally {
            db.close()
        }
    }

    /**
     * DBにあるサンプルデータをすべて取得します。
     */
    private fun findAll(): MutableList<Task> {

        val helper = MySQLiteOpenHelper(this)
        val db: SQLiteDatabase = helper.readableDatabase


        val tasks: MutableList<Task> = mutableListOf()

        // 全件取得
        val sql = " select * " + " from task ;"

        try {
            val cursour = db.rawQuery(sql, emptyArray())
            if (cursour.moveToFirst()) {
                do {
                    val task: Task = createUsingCursor(cursour)
                    tasks.add(task)
                } while (cursour.moveToNext())
            }
        } finally {
            db.close()
        }
        return tasks
    }
}