package com.anselmoalexandre.api

interface NasaApi {
    suspend fun getNewsArticlesRemoteDataSource(): Result<List<RemoteNewsArticle>>
}
