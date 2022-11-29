package br.com.mariojp.todo.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class ToDoItem  (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title : String,
    val description: String
    ): Parcelable
