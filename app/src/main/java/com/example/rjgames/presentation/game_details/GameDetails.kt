package com.example.rjgames.presentation.game_details

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.model.toJSON
import com.example.rjgames.presentation.game_details.components.GameDetailDevelopers
import com.example.rjgames.presentation.game_details.components.GameDetailGenres
import com.example.rjgames.presentation.game_details.components.GameDetailPublishers
import com.example.rjgames.presentation.game_details.components.GameDetailTags
import com.example.rjgames.presentation.game_details.components.GameDetailsHeader
import com.example.rjgames.presentation.game_details.components.GameDetailsRatingBar
import com.example.rjgames.presentation.game_details.components.GameDetailsSectionHeader
import com.example.rjgames.presentation.game_details.components.GameDetailsTopBar
import com.example.rjgames.presentation.navigation.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsPage(
    navController: NavController = rememberNavController(),
    gameId: Int,
    viewModel: GameDetailsViewModel = hiltViewModel(),
) {

    val scrollState: ScrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(gameId) {
        viewModel.getGameDetails(gameId = gameId)
        viewModel.isFavorite(gameId = gameId)
    }

    if (viewModel.state.value.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    } else {
        val game = remember{ viewModel.state.value.gameDetails }

        if (game == null) {
            Text(text = "No game found")
        } else {
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                topBar = {
                    GameDetailsTopBar(
                        navController = navController,
                        isFavorite = viewModel.state.value.isFavorite,
                        onChangeFavorite = { value ->
                            if (value) {
                                viewModel.addToFavorites(game)
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Añadir a la biblioteca",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            } else {
                                viewModel.removeFromFavorites(game)
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = "Quitar de la biblioteca",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        }
                    )
                },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    GameDetailsHeader(game = game)

                    GameDetailsSectionHeader(
                        modifier = Modifier.padding(top = 16.dp),
                        title = "Descripción"
                    )
                    Text(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        text = game.descriptionRaw ?: "No description",
                    )


                    GameDetailsSectionHeader(
                        title = "Generos",
                        modifier = Modifier.padding(top = 16.dp),
                    )
                    GameDetailGenres(
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        genres = game.genres,
                        onItemClick = {
                            val gameQueries = GameQueries(genres = it)
                            val route =
                                Screens.FilteredGamesScreen.route + "/${gameQueries.toJSON()}"
                            navController.navigate(route)
                        }
                    )

                    GameDetailsSectionHeader(
                        title = "Rating",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    GameDetailsRatingBar(
                        modifier = Modifier.padding(
                            top = 16.dp
                        ),
                        game = game
                    )

                    GameDetailsSectionHeader(
                        title = "Developers",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.developers.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No developers found",
                        )
                    } else {
                        GameDetailDevelopers(developers = game.developers)
                    }

                    GameDetailsSectionHeader(
                        title = "Publishers",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.publisher.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No publishers found",
                        )
                    } else {
                        GameDetailPublishers(publishers = game.publisher)
                    }

                    GameDetailsSectionHeader(
                        title = "Tags",
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    if (game.tags.isNullOrEmpty()) {
                        Text(
                            modifier = Modifier.padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            ),
                            text = "No tags found",
                        )
                    } else {
                        GameDetailTags(tags = game.tags)
                    }

                }
            }
        }
    }


}
