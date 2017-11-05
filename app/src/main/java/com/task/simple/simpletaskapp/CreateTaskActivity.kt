package com.task.simple.simpletaskapp

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_create_task.*
import kotlinx.android.synthetic.main.activity_create_task.view.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by scallop316 on 2017/11/04.
 */

class CreateTaskActivity : AppCompatActivity() {

    companion object {

        fun intent(context: Context): Intent =
                Intent(context, CreateTaskActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_task)

        val createButton = findViewById<Button>(R.id.create_button)
        createButton.setOnClickListener {
            val title = create_task_info.task_name_text.text.toString()
//            val deadime = limit_time_text.toString()
//            val age = remaining_time.toString()

            val helper = MySQLiteOpenHelper(this)
            val db: SQLiteDatabase = helper.writableDatabase

            val insertValues = ContentValues()
            insertValues.put("title", title)
            db.insert("task", null, insertValues)
            db.close()
            MainActivity.intent(this).let { startActivity(it) }
        }
    }
}