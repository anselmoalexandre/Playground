package com.anselmoalexandre.data

import com.anselmoalexandre.api.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RemoteNewsArticleApi @Inject constructor(
    private val newsApi: NewsApi,
) : NewsArticleRepository {
    override fun getNewsArticles(): Flow<List<NewsArticle>> = flow {
        newsApi.getNewsArticlesRemoteDataSource()
            .onSuccess { newsArticles ->
                val response = newsArticles.map { newsArticle ->
                    newsArticle.asNewsArticle()
                }
                emit(response)
            }
            .onFailure { throwable ->
                emit(emptyList())
            }
    }

    override fun getNewsAuthor(): Flow<List<NewsAuthor>>  = flow{
        newsApi.getNewsAuthorRemoteDataSource()
            .onSuccess { newsAuthors ->
                val response = newsAuthors.map { newsAuthor ->
                    newsAuthor.asNewsAuthor()
                }

                emit(response)
            }
            .onFailure { throwable ->
                emit(emptyList())
            }
    }
}
