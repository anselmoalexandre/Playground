package com.anselmoalexandre.data

import kotlinx.coroutines.flow.Flow

interface NewsArticleRepository {
    fun getNewsArticles(): Flow<List<NewsArticle>>
    fun getNewsAuthor(): Flow<List<NewsAuthor>>
}
