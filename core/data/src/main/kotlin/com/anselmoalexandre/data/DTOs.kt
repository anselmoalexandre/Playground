package com.anselmoalexandre.data

import androidx.annotation.Keep
import com.anselmoalexandre.api.RemoteNewsArticle

@Keep
data class NewsArticle(
    val id: Int,
    val title: String,
    val author: String,
)

internal fun RemoteNewsArticle.asNewsArticle() = NewsArticle(
    id = this.id,
    title = this.title,
    author = this.author,
)
