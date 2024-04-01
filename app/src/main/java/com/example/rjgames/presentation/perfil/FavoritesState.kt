package com.example.rjgames.presentation.perfil

import com.example.rjgames.domain.model.GameDetails

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<GameDetails> = emptyList(),
    val error: String = "",
)
