package com.anselmoalexandre.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_author")
data class NewsAuthorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val date: String,
)
