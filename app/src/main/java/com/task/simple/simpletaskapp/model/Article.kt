package com.task.simple.simpletaskapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by scallop316 on 2017/11/03.
 */
data class Article(val id: String,
                   val title: String,
                   val url: String,
                   val user: User) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = source.run {
                Article(readString(), readString(), readString(), readParcelable(Article::class.java.classLoader))
            }

            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.run {
            writeString(id)
            writeString(title)
            writeString(url)
            writeParcelable(user, flags)
        }
    }
}