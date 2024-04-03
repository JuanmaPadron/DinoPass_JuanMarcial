package com.example.rjgames.presentation.navigation

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.rjgames.presentation.ui.theme.AppTheme


@Composable
fun RawJetGamesApp() {
    val navController: NavController = rememberNavController()

    AppTheme(useDarkTheme = isSystemInDarkTheme()) {
        Navigation(
            navController = navController as NavHostController
        )
    }
}