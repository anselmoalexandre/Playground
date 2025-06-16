package com.anselmoalexandre.storage.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anselmoalexandre.storage.entity.NewsAuthorEntity
import kotlinx.coroutines.flow.Flow

interface NewsAuthorDao {
    @Query("SELECT * FROM news_author")
    fun getNewsAuthor(): Flow<List<NewsAuthorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAuthor(newsAuthorEntity: NewsAuthorEntity)

    @Delete
    suspend fun deleteAuthor(newsAuthorEntity: NewsAuthorEntity)
}
