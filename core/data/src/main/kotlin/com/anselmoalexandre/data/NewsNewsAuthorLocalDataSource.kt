package com.anselmoalexandre.data

import com.anselmoalexandre.storage.dao.NewsAuthorDao
import javax.inject.Inject

internal class NewsNewsAuthorLocalDataSource @Inject constructor(
    private val authorDao: NewsAuthorDao,
) : NewsAuthorRepository {
    override suspend fun saveNewsAuthor(author: NewsAuthor) {
        val authorEntity = author.asNewsAuthorEntity()
        authorDao.insertAuthor(newsAuthorEntity = authorEntity)
    }
}
