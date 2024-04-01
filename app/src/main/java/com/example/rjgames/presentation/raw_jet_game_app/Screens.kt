package com.example.rjgames.presentation.raw_jet_game_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val arguments: List<NamedNavArgument>? = null
    ){

    object GameDetailsScreen : Screens(
        route = "game/details",
        arguments = listOf(
            navArgument("gameId") {
                type = NavType.IntType
            }
        )
    )

    object FilteredGamesScreen : Screens(
        route = "filtered_games",
        arguments = listOf(
            navArgument("gameQueries") {
                type = NavType.StringType
            }
        )
    )


    sealed class BottomBarScreens(
        route: String,
        val title: String,
        val icon: ImageVector? = null
    ) : Screens(route) {

        object Discover : BottomBarScreens(
            route = "discover",
            title = "Catálogo",
        )

        object Search : BottomBarScreens(
            route = "search",
            title = "Planes mensuales",
            icon = Icons.Rounded.ShoppingCart
        )

        object Perfil : BottomBarScreens(
            route = "perfil",
            title = "Perfil",
            icon = Icons.Rounded.AccountCircle
        )

        object Login : BottomBarScreens(
            route = "login",
            title = "Login"
        )

        object CrearCuenta : BottomBarScreens(
            route = "crearcuenta",
            title = "crearcuenta"
        )
        object CarritoPlanMensual : BottomBarScreens(
            route = "carrito",
            title = "Planes Mensuales"
        )
    }

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/{$arg}")
            }
        }
    }

}
