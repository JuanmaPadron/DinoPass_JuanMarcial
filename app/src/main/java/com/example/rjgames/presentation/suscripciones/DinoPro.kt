package com.example.rjgames.presentation.suscripciones

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.rjgames.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DinoPro(navController: NavController) {
    var cardNumber by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    Scaffold(
        topBar = { TopAppBarDinoPro(navController = navController)}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.dinopro_removebg_preview),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(350.dp)
                    .padding(10.dp)
            )
            Text(text = "Datos necesarios para finalizar la compra", fontSize = 17.sp)
            Text(text = "Precio final: 14,99€", fontSize = 15.sp)

            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                label = { Text("Número de tarjeta") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = expirationDate,
                onValueChange = { expirationDate = it },
                label = { Text("Fecha de expiración (MM/YY)") }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = cvv,
                onValueChange = { cvv = it },
                label = { Text("CVV") }
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {  }) {
                Text("Pagar")
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDinoPro(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "DinoPro",
                fontSize = 18.sp
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier,
        navigationIcon = { },
        actions = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atras"
                )
            }

        }
    )
}