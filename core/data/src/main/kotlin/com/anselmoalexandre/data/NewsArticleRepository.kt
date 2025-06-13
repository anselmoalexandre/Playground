package com.anselmoalexandre.data

import kotlinx.coroutines.flow.Flow

interface NewsArticleRepository {
    fun getNewsArticles(): Flow<NewsArticle>
}
