package com.anselmoalexandre.playground.articles.domain

import com.anselmoalexandre.data.NewsArticle
import com.anselmoalexandre.data.NewsArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsArticlesUseCase @Inject constructor(
    private val newsArticleRepository: NewsArticleRepository,
) {
    operator fun invoke(): Flow<List<NewsArticle>> = newsArticleRepository.getNewsArticles()
}
