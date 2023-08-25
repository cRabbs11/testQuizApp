package com.ekochkov.testquizapp.di.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.ekochkov.testquizapp.di.data.AppDatabase

@Entity(tableName = AppDatabase.GAME_TABLE_NAME, indices = [Index(value = ["id"], unique = true)])
data class Game(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "isDone") val isDone: Boolean) {
}