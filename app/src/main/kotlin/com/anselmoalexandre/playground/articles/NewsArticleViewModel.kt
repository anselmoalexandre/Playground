package com.anselmoalexandre.playground.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anselmoalexandre.data.NewsArticle
import com.anselmoalexandre.playground.articles.domain.NewsArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class NewsArticleViewModel @Inject constructor (
    private val newsArticlesUseCase: NewsArticlesUseCase,
) : ViewModel() {
    val uiState: StateFlow<UiState> =
        newsArticlesUseCase.invoke()
            .onStart {
                UiState(
                    isLoading = true,
                    articles = emptyList(),
                    error = null,
                )
            }
            .map { list ->
                UiState(
                    isLoading = false,
                    articles = list,
                    error = null,
                )
            }
            .onEmpty {
                UiState(
                    isLoading = false,
                    articles = emptyList(),
                    error = Throwable(message = "Error have occurred"),
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = UiState.Default,
            )

    data class UiState(
        val isLoading: Boolean,
        val articles: List<NewsArticle>,
        val error: Throwable?,
    ) {
        companion object {
            val Default = UiState(
                isLoading = false,
                articles = emptyList(),
                error = null,
            )
        }
    }
}
