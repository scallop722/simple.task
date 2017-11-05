package com.task.simple.simpletaskapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by scallop316 on 2017/11/03.
 */
data class Task(val id: String,
                val title: String,
                val url: String) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Task> = object : Parcelable.Creator<Task> {
            override fun createFromParcel(source: Parcel): Task = source.run {
                Task(readString(), readString(), readString())
            }

            override fun newArray(size: Int): Array<Task?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(title)
            writeString(url)
        }
    }
}