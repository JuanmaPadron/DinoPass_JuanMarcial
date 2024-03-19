package com.example.dinopass_juanma.screens.login



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.dinopass_juanma.R

@Composable
fun Login(continueCatalogo: () -> Unit, continueCrearCuenta: () -> Unit) {
    var usuario by remember { mutableStateOf("") }
    var contrasenia by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    val usuarioCorrecto = "123"
    val contraseniaCorrecta = "123"

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
        Text(text = "Bienvenido")
        SimpleOutlinedTextFieldSample("Usuario", usuario, isSingleLine = true) { usuario = it }
        SimpleOutlinedTextFieldSample("Contraseña", contrasenia, true, isSingleLine = true) { contrasenia = it }

        if (showError) {
            Text(
                text = "Usuario o contraseña incorrectos",
                color = Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }

        Button(
            onClick = {
                //   if (usuario.equals(usuarioCorrecto) && contrasenia.equals(contraseniaCorrecta)) {
                continueCatalogo()
                //   } else {
                //     showError = true
                //   }
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Login")
        }
        Text(text = "¿Eres nuevo?")
        Button(
            onClick = { continueCrearCuenta() },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Crear cuenta")
        }
    }
}


@Composable
fun SimpleOutlinedTextFieldSample(
    label: String,
    value: String,
    isPassword: Boolean = false,
    isSingleLine: Boolean,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.padding(10.dp),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text),
        singleLine = isSingleLine
    )
}