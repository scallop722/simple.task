package com.task.simple.simpletaskapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by scallop316 on 2017/11/05.
 */
class MySQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context, "task.db", null, 1) {

    /**
     * テーブルを作成します
     */
    override fun onCreate(db: SQLiteDatabase) {
        val sql: String =
                " create table task( " +
                " _id integer primary key autoincrement not null, " +
                " title text not null, " +
                " parent_task_id integer, " +
                " hierarchy_number integer, " +
                " limit_time text, " +
                " estimated_time real " +
                " ); "
        db.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}