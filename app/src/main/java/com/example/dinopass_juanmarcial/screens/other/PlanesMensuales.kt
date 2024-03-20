package com.example.dinopass_juanmarcial.screens.other


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
        Column(modifier = Modifier.padding(innerPadding)) {
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .size(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Text(text = "DinoBasic ")
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .size(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Text(text = "DinoPro ")
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .size(200.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
            ) {
                Text(text = "DinoPremium ")
            }
        }
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

