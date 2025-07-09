package com.anselmoalexandre.data.di

import com.anselmoalexandre.data.NewsAuthorRepository
import com.anselmoalexandre.data.NewsNewsAuthorLocalDataSource
import com.anselmoalexandre.data.NewsArticleRepository
import com.anselmoalexandre.data.RemoteNewsArticleApi
import com.anselmoalexandre.storage.dao.NewsAuthorDao
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {
    @Binds
    fun bindNewsArticleRepository(
        remoteNewsArticleApi: RemoteNewsArticleApi,
    ): NewsArticleRepository {
        return remoteNewsArticleApi
    }

    @Binds
    fun bindAuthorRepository(
        newsAuthorDao: NewsAuthorDao
    ): NewsAuthorRepository {
        return NewsNewsAuthorLocalDataSource(newsAuthorDao)
    }
}
