package com.task.simple.simpletaskapp.model

import android.database.Cursor
import android.os.Parcel
import android.os.Parcelable
import java.sql.Date

fun createUsingCursor(cursor: Cursor): Task =
            Task(cursor.getLong(cursor.getColumnIndex("_id")),
                    cursor.getString(cursor.getColumnIndex("title")))

/**
 * Created by scallop316 on 2017/11/03.
 */
data class Task(val id: Long,
                val title: String,
                val parentTaskId: Int?,
                val hierarchyNumber: Int?,
                val limitTime: Date?,
                val estimatedTime: Double?) : Parcelable {

    constructor(id: Long, title: String) : this(id, title, null, null, null, null)

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Task> = object : Parcelable.Creator<Task> {
            override fun createFromParcel(source: Parcel): Task = source.run {
                Task(readLong(), readString())
            }

            override fun newArray(size: Int): Array<Task?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeLong(id)
            writeString(title)
        }
    }
}