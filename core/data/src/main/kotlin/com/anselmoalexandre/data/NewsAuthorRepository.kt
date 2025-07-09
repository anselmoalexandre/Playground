package com.anselmoalexandre.data

interface NewsAuthorRepository {
    suspend fun saveNewsAuthor(author: NewsAuthor)
}
