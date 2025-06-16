package com.anselmoalexandre.storage.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anselmoalexandre.storage.entity.NewsArticleEntity
import kotlinx.coroutines.flow.Flow

interface NewsArticleDao {
    @Query("SELECT * FROM news_article")
    fun getNewsArticle(): Flow<List<NewsArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsArticle(newsArticleEntity: NewsArticleEntity)

    @Delete
    suspend fun deleteNewsArticle(newsArticleEntity: NewsArticleEntity)
}