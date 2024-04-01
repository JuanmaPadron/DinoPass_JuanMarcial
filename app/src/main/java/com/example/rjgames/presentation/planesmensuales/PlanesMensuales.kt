package com.example.rjgames.presentation.planesmensuales

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
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
import androidx.navigation.NavHostController
import com.example.rjgames.presentation.components.CustomTopBar
import com.example.rjgames.presentation.components.MainBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanesMensuales(
    navController: NavHostController,
    ContinueCarrito: () -> Unit
    ) {

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
                        onClick = { ContinueCarrito() },
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
                        onClick = { ContinueCarrito() },
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
                        onClick = { ContinueCarrito() },
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


