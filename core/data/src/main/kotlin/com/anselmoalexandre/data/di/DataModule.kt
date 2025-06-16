package com.anselmoalexandre.data.di

import com.anselmoalexandre.data.NewsArticleRepository
import com.anselmoalexandre.data.RemoteNewsArticleApi
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
}
