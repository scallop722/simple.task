package com.task.simple.simpletaskapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.task.simple.simpletaskapp.model.Article
import com.task.simple.simpletaskapp.view.ArticleView

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