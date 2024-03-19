package com.example.dinopass_juanmarcial.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dinopass_juanma.R
import com.example.dinopass_juanma.screens.login.SimpleOutlinedTextFieldSample

@Composable
fun CrearCuenta(
    continueCatalogo: () -> Unit,
    onError : (String) -> Unit = {}
                ) {
    var usuario by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var repetirContrasenia by remember { mutableStateOf("") }

    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.dinopasslogo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(350.dp)
                .padding(10.dp)
        )
        Text(text = "Crear cuenta")
        SimpleOutlinedTextFieldSample("Correo", correo, isSingleLine = true) { correo = it }
        SimpleOutlinedTextFieldSample("Usuario", usuario, isSingleLine = true) { usuario = it }
        SimpleOutlinedTextFieldSample("Contraseña", contrasenia, true, isSingleLine = true) { contrasenia = it }
        SimpleOutlinedTextFieldSample("Repetir contraseña", repetirContrasenia, true, isSingleLine = true) { repetirContrasenia = it }

        Button(
            onClick = {
                    if (contrasenia.trim() == repetirContrasenia.trim()){
                        continueCatalogo()
                    } else {
                        onError("Las contraseñas no coinciden")
                    }
                      },
            modifier = Modifier.padding(8.dp)
        ) {

            Text("Crear cuenta")
        }
    }
}

