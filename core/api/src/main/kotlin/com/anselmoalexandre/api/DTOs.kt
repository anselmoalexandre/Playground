package com.anselmoalexandre.api

import androidx.annotation.Keep

@Keep
data class RemoteNewsArticle(
    val id: Int,
    val title: String,
    val author: String,
)
