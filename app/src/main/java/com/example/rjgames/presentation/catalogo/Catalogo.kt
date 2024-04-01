package com.example.rjgames.presentation.catalogo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rjgames.domain.model.Game
import com.example.rjgames.presentation.catalogo.components.DiscoverSearchCard
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar
import com.example.rjgames.presentation.components.SectionTitleWithButton
import com.example.rjgames.presentation.components.best_games_of_year_list.BestGameOfYearList
import com.example.rjgames.presentation.components.genre_list.GenreList
import com.example.rjgames.presentation.components.vertical_game_list.verticalGameListWithPagination
import com.example.rjgames.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Catalogo(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DiscoverViewModel = hiltViewModel()
) {

    val bestOfAllTimeGames: LazyPagingItems<Game> = viewModel
        .state.value.bestOfAllTimeGames
        .collectAsLazyPagingItems()


    Scaffold(
        topBar = { CustomTopBar(subtitle = "Catálogo") },
        bottomBar = { MainBottomBar(navController = navController) }
    ) { paddingValues ->


        when (bestOfAllTimeGames.itemCount) {
            0 -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    state = viewModel.lazyListState
                ) {

                    item {
                        DiscoverSearchCard(
                            modifier = Modifier.padding(top = 4.dp),
                            onClick = {
                                navController.navigate(Screens.BottomBarScreens.Search.route) {
                                    popUpTo(navController.graph.startDestinationId){
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }

                    item {
                        SectionTitleWithButton(title = "Generos")
                        GenreList(
                            navController = navController,
                        )
                    }

                    item {
                        SectionTitleWithButton(
                            title = "Mejor valorados",
                            buttonText = "Ver todos",
                            onClick = {}
                        )

                        BestGameOfYearList(navController = navController)
                    }


                    item {
                        SectionTitleWithButton(
                            title = "Mejor valorados",
                        )
                    }

                    verticalGameListWithPagination(
                        listWithPagination = bestOfAllTimeGames,
                        navController = navController
                    )

                    item {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                        )
                    }

                }
            }
        }

    }
}
