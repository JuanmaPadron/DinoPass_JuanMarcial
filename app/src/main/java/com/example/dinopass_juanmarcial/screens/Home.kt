package com.example.dinopass_juanmarcial.screens

import com.example.dinopass_juanmarcial.R
import android.app.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dinopass_juanmarcial.screens.login.Login
import com.example.dinopass_juanmarcial.screens.other.Catalogo
import com.example.dinopass_juanmarcial.screens.other.Perfil
import com.example.dinopass_juanmarcial.screens.other.PlanesMensuales
import com.example.dinopass_juanmarcial.screens.login.CrearCuenta

enum class Home(val title : Int) {
    Login(title = R.string.login),
    CrearCuenta(title = R.string.catalogo),
    Catalogo(title = R.string.crearCuenta),
    Perfil(title = R.string.perfil),
    PlanesMensuales(title = R.string.planesMensuales)

}
@Composable
fun MyHome(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Home.Login.name,
    ) {
        composable(route = Home.Login.name) {
            Login(continueCatalogo = { navController.navigate(Home.Catalogo.name) },
                continueCrearCuenta = { navController.navigate(Home.CrearCuenta.name) })
        }
        composable(route = Home.CrearCuenta.name) {
            CrearCuenta(continueCatalogo = { navController.navigate(Home.Catalogo.name) },
                onError = { errorMessage ->
                    AlertDialog.Builder(context)
                        .setTitle("Error")
                        .setMessage(errorMessage)
                        .setPositiveButton("OK") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .show()
                })
        }
        composable(route = Home.Catalogo.name){
            Catalogo(
                continuePerfil = { navController.navigate(Home.Perfil.name) },
                continueCatalogo = {navController.navigate(Home.Catalogo.name)},
                continuePlanesMensuales = { navController.navigate(Home.PlanesMensuales.name) }
            )
        }
        composable(route = Home.Perfil.name) {
            Perfil(
                continuePerfil = { navController.navigate(Home.Perfil.name) },
                continueCatalogo = {navController.navigate(Home.Catalogo.name)},
                continuePlanesMensuales = { navController.navigate(Home.PlanesMensuales.name) },
                cerrarSesion = {navController.navigate(Home.Login.name)})
        }
        composable(route = Home.PlanesMensuales.name){
            PlanesMensuales(
                continuePerfil = { navController.navigate(Home.Perfil.name) },
                continueCatalogo = {navController.navigate(Home.Catalogo.name)},
                continuePlanesMensuales = { navController.navigate(Home.PlanesMensuales.name) })
        }
    }
}