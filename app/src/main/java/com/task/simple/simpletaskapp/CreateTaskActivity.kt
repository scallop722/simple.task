package com.task.simple.simpletaskapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

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
    }
}