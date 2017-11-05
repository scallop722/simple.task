package com.task.simple.simpletaskapp.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.task.simple.simpletaskapp.R
import com.task.simple.simpletaskapp.bindView
import com.task.simple.simpletaskapp.model.Task

/**
 * Created by scallop316 on 2017/11/03.
 */
class TaskView : FrameLayout {

    constructor(context: Context?) : super(context)

    constructor(context: Context?,
                attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    val profileImageView: ImageView by bindView(R.id.profile_image_view)

    val titleTextView: TextView by bindView(R.id.title_text_view)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_task, this)
    }

    fun setTask(task: Task) {
        titleTextView.text = task.title

        profileImageView.setBackgroundColor(Color.RED)
    }
}