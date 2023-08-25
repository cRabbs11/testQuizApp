package com.ekochkov.testquizapp.di.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ekochkov.testquizapp.di.data.AppDatabase

@Entity(tableName = AppDatabase.ANSWER_TABLE_NAME, indices = [Index(value = ["id"], unique = true)])
data class Answer(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "questionId") val questionId: Int,
    @ColumnInfo(name = "gameId" ) val gameId: Int,
    @ColumnInfo(name = "answer") val answer: String
)