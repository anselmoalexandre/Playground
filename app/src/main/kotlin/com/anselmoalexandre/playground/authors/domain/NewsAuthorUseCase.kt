package com.anselmoalexandre.playground.authors.domain

import com.anselmoalexandre.data.NewsArticleRepository
import com.anselmoalexandre.data.NewsAuthor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsAuthorUseCase @Inject constructor(
    private val newsArticleRepository: NewsArticleRepository,
) {
    operator fun invoke(): Flow<List<NewsAuthor>> = newsArticleRepository.getNewsAuthor()
}
