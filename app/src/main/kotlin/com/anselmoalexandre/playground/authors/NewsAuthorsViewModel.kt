package com.anselmoalexandre.playground.authors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anselmoalexandre.data.NewsArticle
import com.anselmoalexandre.data.NewsAuthor
import com.anselmoalexandre.playground.articles.domain.NewsArticlesUseCase
import com.anselmoalexandre.playground.authors.domain.NewsAuthorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class NewsAuthorsViewModel @Inject constructor(
    private val newsArticlesUseCase: NewsArticlesUseCase,
    private val newsAuthorUseCase: NewsAuthorUseCase,
) : ViewModel() {

    val uiState: StateFlow<UiState> = combine(
        newsAuthorUseCase.invoke(),
        newsArticlesUseCase.invoke()
    ) { authors, articles ->
        UiState(
            loading = false,
            articleAuthor = authors to articles,
            error = null,
        )
    }
        .onStart {
            UiState(loading = true)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState()
        )

    data class UiState(
        val loading: Boolean = false,
        val articleAuthor: Pair<List<NewsAuthor>, List<NewsArticle>> = Pair(
            emptyList(),
            emptyList()
        ),
        val error: Throwable? = null,
    )
}
