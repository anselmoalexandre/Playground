package com.anselmoalexandre.storage.di

import android.content.Context
import androidx.room.Room
import com.anselmoalexandre.storage.NewsArticleDatabase
import com.anselmoalexandre.storage.dao.NewsArticleDao
import com.anselmoalexandre.storage.dao.NewsAuthorDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NewsArticleDatabase {
        return Room.databaseBuilder(
            context = context,
            NewsArticleDatabase::class.java,
            name = NewsArticleDatabase.NAME
        ).addMigrations().build()
    }

    @Provides
    fun providesNewsArticleDao(db: NewsArticleDatabase): NewsArticleDao = db.newsArticleDao()

    @Provides
    fun providesNewsAuthorDao(db: NewsArticleDatabase): NewsAuthorDao = db.newsAuthorDao()
}
