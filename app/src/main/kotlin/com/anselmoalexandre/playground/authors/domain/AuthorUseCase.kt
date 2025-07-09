package com.anselmoalexandre.playground.authors.domain

import com.anselmoalexandre.data.NewsAuthor
import com.anselmoalexandre.data.NewsAuthorRepository
import javax.inject.Inject

class AuthorUseCase @Inject constructor(
    private val newsAuthorRepository: NewsAuthorRepository,
) {
    suspend operator fun invoke(author: NewsAuthor) {
        newsAuthorRepository.saveNewsAuthor(author)
    }
}
