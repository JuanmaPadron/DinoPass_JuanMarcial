package com.example.rjgames.presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.model.toGameQueries
import com.example.rjgames.presentation.catalogo.Catalogo
import com.example.rjgames.presentation.crearcuenta.CrearCuenta
import com.example.rjgames.presentation.filtered_games.FilteredGames
import com.example.rjgames.presentation.game_details.GameDetailsPage
import com.example.rjgames.presentation.login.Inicio
import com.example.rjgames.presentation.login.Login
import com.example.rjgames.presentation.perfil.Perfil
import com.example.rjgames.presentation.planesmensuales.PlanesMensuales
import com.example.rjgames.presentation.suscripciones.DinoBasic
import com.example.rjgames.presentation.suscripciones.DinoPremium
import com.example.rjgames.presentation.suscripciones.DinoPro


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.BottomBarScreens.Inicio.route
    ) {
        composable(Screens.BottomBarScreens.Inicio.route){
            Inicio(navController = navController)
        }
        composable(Screens.BottomBarScreens.Login.route){
            Login(navController)
        }
        composable(Screens.BottomBarScreens.CrearCuenta.route){
            CrearCuenta(continueCatalogo = { navController.navigate(Screens.BottomBarScreens.Discover.route) })
        }
        composable(Screens.BottomBarScreens.Discover.route) {
            Catalogo(navController = navController)
        }

        composable(Screens.BottomBarScreens.Search.route){
            PlanesMensuales(navController = navController,
                ContinueDinoBasic = {navController.navigate(Screens.BottomBarScreens.DinoBasic.route)},
                ContinueDinoPro = { navController.navigate(Screens.BottomBarScreens.DinoPro.route) },
                ContinueDinoPremium = { navController.navigate(Screens.BottomBarScreens.DinoPremium.route) })
        }

        composable(Screens.BottomBarScreens.Perfil.route){
            Perfil(navController = navController,
                cerrarSesion = { navController.navigate(Screens.BottomBarScreens.Login.route) })
        }

        composable(
            Screens.GameDetailsScreen.withArgs("gameId"),
            arguments = Screens.GameDetailsScreen.arguments!!
        ){
            GameDetailsPage(
                navController = navController,
                gameId = it.arguments?.getInt("gameId") ?: 0
            )
        }
        composable(Screens.BottomBarScreens.DinoBasic.route){
            DinoBasic(navController)
        }
        composable(Screens.BottomBarScreens.DinoPro.route){
            DinoPro(navController)
        }
        composable(Screens.BottomBarScreens.DinoPremium.route){
            DinoPremium(navController)
        }

        composable(
            Screens.FilteredGamesScreen.withArgs("gameQueries"),
            arguments = Screens.FilteredGamesScreen.arguments!!
        ){
            FilteredGames(
                navController = navController,
                gameQueries = it.arguments?.getString("gameQueries")
                    ?.toGameQueries() ?: GameQueries()
            )
        }

    }


}