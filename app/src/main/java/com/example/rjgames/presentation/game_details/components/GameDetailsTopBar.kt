package com.example.rjgames.presentation.game_details.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailsTopBar(
    modifier: Modifier = Modifier,
    navController: NavController,
    isFavorite: Boolean = false,
    onChangeFavorite: (Boolean) -> Unit = { }
) {

    var isFavoriteState by remember { mutableStateOf(isFavorite) }

    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        title = {},
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        },
        actions = {

            if (isFavoriteState) {
                Button(
                    modifier = Modifier.padding(
                        end = 16.dp
                    ).animateContentSize(),
                    onClick = {
                        onChangeFavorite(false)
                        isFavoriteState = false
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = MaterialTheme.colorScheme.onError
                    )
                ) {
                    Icon(
                        Icons.Rounded.Bookmark,
                        contentDescription = "Quitar de la biblioteca",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Quitar de la biblioteca")
                }

            } else {
                Button(
                    modifier = Modifier.padding(
                        end = 16.dp
                    ).animateContentSize(),
                    onClick = {
                        onChangeFavorite(true)
                        isFavoriteState = true
                    },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                ) {
                    Icon(
                        Icons.Rounded.BookmarkBorder,
                        contentDescription = "Añadir a la biblioteca",
                        modifier = Modifier.size(ButtonDefaults.IconSize),
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Añadir a la biblioteca")
                }

            }

        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    )
}

@Preview(name = "GameDetailsTopBar")
@Composable
private fun PreviewGameDetailsTopBar() {
    GameDetailsTopBar(
        navController = rememberNavController(),
    )

}