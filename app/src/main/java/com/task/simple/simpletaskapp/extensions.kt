package com.task.simple.simpletaskapp

import android.support.annotation.IdRes
import android.view.View

/**
 * Created by scallop316 on 2017/11/03.
 */
fun <T : View> View.bindView(@IdRes id: Int): Lazy<T> = lazy {
    findViewById<T>(id)
}