package com.example.rjgames.presentation.perfil

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rjgames.data.mapper.toGame
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar
import com.example.rjgames.presentation.components.vertical_game_list.VerticalGameListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Perfil(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: FavoritesViewModel = hiltViewModel(),
    cerrarSesion: () -> Unit
) {

    val listState = rememberLazyListState()

    Scaffold(
        topBar = { CustomTopBar(subtitle = "Perfil") },
        bottomBar = { MainBottomBar(navController) }
    ) { paddingValues ->

        if (viewModel.state.value.isLoading) {
            Box(modifier = modifier.padding(paddingValues)) {
                Text(text = "Cargando...")
            }
        }else{
                Column(
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .size(200.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                    ){
                        Text(
                            text = "Nombre: ",
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "Usuario: ",
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "Contraseña: ****** ",
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "Planes mensuales: ",
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )
                    }
                    Button(onClick = { cerrarSesion() },
                        colors = ButtonDefaults.buttonColors(Color.Red),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(text = "Cerrar sesión")
                    }
                Text(text = "Mi biblioteca",
                    fontSize = 20.sp)
                LazyColumn(
                    state = listState,
                    modifier = modifier
                        .padding(paddingValues)
                        .fillMaxSize()) {
                    items(viewModel.state.value.favorites.size) {
                        VerticalGameListItem(
                            navController = navController,
                            game = viewModel.state.value.favorites[it].toGame(),
                        )
                    }
                    }
                }
            }
    }
}
