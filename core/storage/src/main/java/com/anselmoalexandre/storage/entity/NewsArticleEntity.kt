package com.anselmoalexandre.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_article")
data class NewsArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String,
)
