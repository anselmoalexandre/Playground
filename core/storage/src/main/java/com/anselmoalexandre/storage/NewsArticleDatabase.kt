package com.anselmoalexandre.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anselmoalexandre.storage.dao.NewsArticleDao
import com.anselmoalexandre.storage.dao.NewsAuthorDao
import com.anselmoalexandre.storage.entity.NewsArticleEntity
import com.anselmoalexandre.storage.entity.NewsAuthorEntity

@Database(
    entities = [NewsArticleEntity::class, NewsAuthorEntity::class],
    version = 1,
    exportSchema = true
)
abstract class NewsArticleDatabase : RoomDatabase() {
    abstract fun newsArticleDao(): NewsArticleDao
    abstract fun newsAuthorDao(): NewsAuthorDao

    companion object {
        const val NAME = "news-article.db"
    }
}