package com.example.rjgames.presentation.raw_jet_game_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rjgames.domain.model.GameQueries
import com.example.rjgames.domain.model.toGameQueries
import com.example.rjgames.presentation.crearcuenta.CrearCuenta
import com.example.rjgames.presentation.discover.Discover
import com.example.rjgames.presentation.favorites.Perfil
import com.example.rjgames.presentation.filtered_games.FilteredGames
import com.example.rjgames.presentation.game_details.GameDetailsPage
import com.example.rjgames.presentation.login.Login
import com.example.rjgames.presentation.search.PlanesMensuales
import com.example.rjgames.presentation.suscripciones.CarritoPlanMensual


@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.BottomBarScreens.Login.route
    ) {
        composable(Screens.BottomBarScreens.Login.route){
            Login(continueCatalogo = { navController.navigate(Screens.BottomBarScreens.Discover.route) },
                continueCrearCuenta = { navController.navigate(Screens.BottomBarScreens.CrearCuenta.route) })
        }
        composable(Screens.BottomBarScreens.CrearCuenta.route){
            CrearCuenta(continueCatalogo = { navController.navigate(Screens.BottomBarScreens.Discover.route) })
        }
        composable(Screens.BottomBarScreens.Discover.route) {
            Discover(navController = navController)
        }

        composable(Screens.BottomBarScreens.Search.route){
            PlanesMensuales(navController = navController,
                ContinueDinoBasic = {navController.navigate(Screens.BottomBarScreens.CarritoPlanMensual.route)},
                ContinueDinoPro = {},
                ContinueDinoPremium = {})
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
        composable(Screens.BottomBarScreens.CarritoPlanMensual.route){
            CarritoPlanMensual()
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