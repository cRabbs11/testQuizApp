package com.ekochkov.testquizapp.di.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ekochkov.testquizapp.di.data.AppDatabase

@Entity(tableName = AppDatabase.QUESTION_TABLE_NAME, indices = [Index(value = ["id"], unique = true)])
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "question") val question: String,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "answerVar1") val answerVar1: String,
    @ColumnInfo(name = "answerVar2") val answerVar2: String,
    @ColumnInfo(name = "answerVar3") val answerVar3: String,
    @ColumnInfo(name = "answerVar4") val answerVar4: String,
    @ColumnInfo(name = "rightAnswer") val rightAnswer: String,
    @ColumnInfo(name = "playerAnswer") var playerAnswer: String = NO_ANSWER) {

    companion object {
        const val NO_ANSWER = "no_answer"
    }
}
