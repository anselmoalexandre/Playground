package com.anselmoalexandre.data

import androidx.annotation.Keep
import com.anselmoalexandre.api.RemoteNewsArticle
import com.anselmoalexandre.api.RemoteNewsAuthor
import com.anselmoalexandre.storage.entity.NewsArticleEntity
import com.anselmoalexandre.storage.entity.NewsAuthorEntity

@Keep
data class NewsArticle(
    val id: Int,
    val title: String,
    val author: String,
)

@Keep
data class NewsAuthor(
    val id: Int,
    val name: String,
    val date: String,
)

internal fun RemoteNewsArticle.asNewsArticle() = NewsArticle(
    id = this.id,
    title = this.title,
    author = this.author,
)

internal fun NewsArticleEntity.asNewsArticle() = NewsArticle(
    id = this.id,
    title = this.title,
    author = this.author,
)

internal fun RemoteNewsAuthor.asNewsAuthor() = NewsAuthor(
    id = this.id,
    name = this.name,
    date = this.date,
)

internal fun NewsAuthorEntity.asNewsAuthor() = NewsAuthor(
    id = this.id,
    name = this.name,
    date = this.date,
)
