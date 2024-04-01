package com.example.rjgames.presentation.components

import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rjgames.R
import com.example.rjgames.presentation.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainBottomBar(
    navController: NavController,
) {

    val screens: List<Screens.BottomBarScreens> = listOf(
        Screens.BottomBarScreens.Discover,
        Screens.BottomBarScreens.Search,
        Screens.BottomBarScreens.Perfil
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    if (navController.currentDestination?.route != screen.route) {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                },
                icon = {
                    BadgedBox(
                        badge = {}
                    ) {
                        if (screen == Screens.BottomBarScreens.Discover) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_sports_esports_24),
                                contentDescription = screen.title,
                            )
                        } else {
                            Icon(
                                imageVector = screen.icon!!,
                                contentDescription = screen.title
                            )
                        }

                    }
                },
                label = {
                    Text(text = screen.title)
                }
            )

        }
    }

}