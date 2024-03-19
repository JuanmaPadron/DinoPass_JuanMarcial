package com.example.dinopass_juanma.screens.other

import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

@Composable
fun PlanesMensuales(continuePerfil: () -> Unit,
           continueCatalogo: () -> Unit,
           continuePlanesMensuales: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBarPlanesMensuales()
        },
        bottomBar = {
            BottomAppBarContent(continuePerfil, continueCatalogo, continuePlanesMensuales)
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Planes Mensuales"
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPlanesMensuales(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = "Planes Mensuales") },
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

