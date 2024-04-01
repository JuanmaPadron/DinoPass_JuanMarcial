package com.example.rjgames.presentation.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar
import com.example.rjgames.presentation.components.SearchBar
import com.example.rjgames.presentation.components.vertical_game_list.verticalGameListWithoutPagination
import com.example.rjgames.presentation.search.components.SearchBodyLottie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanesMensuales(navController: NavHostController,
                    ContinueDinoBasic: () -> Unit,
                    ContinueDinoPro: () -> Unit,
                    ContinueDinoPremium: () -> Unit) {

    Scaffold(
        topBar = { CustomTopBar(subtitle = "Planes mensuales") },
        bottomBar = { MainBottomBar(navController) }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp), // Ajusta la altura según tu preferencia
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "DinoBasic",
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 19.sp,

                        )
                    Text(
                        text = "Más de 5.000 juegos",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Nuevos juegos mensualmente",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Juegos de PC",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Button(
                        onClick = { ContinueDinoBasic() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .paddingFromBaseline(140.dp)
                    ) {
                        Text(
                            text = "Suscribirse",
                            color = Color.Black
                        )
                    }

                }
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp), // Ajusta la altura según tu preferencia
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "DinoPro",
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 19.sp,

                        )
                    Text(
                        text = "Más de 10.000 juegos",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Nuevos juegos mensualmente",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Juegos de PC y movil",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Button(
                        onClick = { ContinueDinoPro() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .paddingFromBaseline(140.dp)
                    ) {
                        Text(
                            text = "Suscribirse",
                            color = Color.Black
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(200.dp), // Ajusta la altura según tu preferencia
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                ) {
                    Text(
                        text = "DinoPremium",
                        color = Color.Black,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 19.sp,

                        )
                    Text(
                        text = "Más de 50.000 juegos",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Nuevos juegos mensualmente",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Juegos de PC, movil y consolas(PS5, PS4, Xbox Series X)",
                        color = Color.Black,
                        fontSize = 13.sp
                    )
                    Button(
                        onClick = { ContinueDinoPremium() },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .paddingFromBaseline(140.dp)
                    ) {
                        Text(
                            text = "Suscribirse",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    }

}


