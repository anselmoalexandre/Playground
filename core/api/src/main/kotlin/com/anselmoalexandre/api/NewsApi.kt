package com.anselmoalexandre.api

interface NewsApi {
    suspend fun getNewsArticlesRemoteDataSource(): Result<List<RemoteNewsArticle>>
    suspend fun getNewsAuthorRemoteDataSource(): Result<List<RemoteNewsAuthor>>
}
