package com.example.dinopass_juanma.screens.other

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun Perfil(continuePerfil: () -> Unit,
           continueCatalogo: () -> Unit,
           continuePlanesMensuales: () -> Unit,
           cerrarSesion: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBarPerfil()
        },
        bottomBar = {
            BottomAppBarContent(continuePerfil, continueCatalogo, continuePlanesMensuales)
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Perfil")
            Button(onClick = { cerrarSesion() },
                colors = ButtonDefaults.buttonColors(Color.Red),
            ) {
                Text(text = "Cerrar sesión")
            }
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPerfil(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(text = "Perfil") },
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

