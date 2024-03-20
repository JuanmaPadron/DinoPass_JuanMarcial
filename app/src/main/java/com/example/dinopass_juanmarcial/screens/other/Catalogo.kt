package com.example.dinopass_juanmarcial.screens.other


import CustomFamilyFont
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Gamepad
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Catalogo(continuePerfil: () -> Unit,
             continueCatalogo: () -> Unit,
             continuePlanesMensuales: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBarCatalogo()
        },
        bottomBar = {
            BottomAppBarContent(continuePerfil, continueCatalogo, continuePlanesMensuales)
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Catalogo"
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCatalogo(modifier: Modifier = Modifier) {
    val customFontFamily = CustomFamilyFont()
    TopAppBar(
        title = { Text(text = "Catalogo",
            fontFamily = customFontFamily,
            fontSize = 18.sp) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier,
        navigationIcon = {  },
        actions = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Busqueda"
            )
        }
    )
}

@Composable
fun BottomAppBarContent(
    continuePerfil: () -> Unit,
    continueCatalogo: () -> Unit,
    continuePlanesMensuales: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Row(Modifier.padding(8.dp)) {
            IconButton(
                onClick = { continueCatalogo() },
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Gamepad,
                    contentDescription = "Catalogo",
                )
            }
            IconButton(
                onClick = { continuePlanesMensuales() },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Planes mensuales"
                )
            }
            IconButton(
                onClick = { continuePerfil() },
                modifier = Modifier.weight(1f)
            ) {
                Icon(imageVector = Icons.Filled.AccountCircle, contentDescription = "Perfil")
            }
        }
    }
}