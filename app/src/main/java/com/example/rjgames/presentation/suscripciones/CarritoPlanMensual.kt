package com.example.rjgames.presentation.suscripciones

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MonthlyPlan(
    val name: String,
    val price: Double,
    var quantity: Int = 1
)
data class Product(
    val name: String,
    val price: Double,
    var quantity: Int = 1 
)
@Composable
fun PlanesMensuales(plan: MonthlyPlan, onAddToCart: (MonthlyPlan) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = plan.name)
                Text(text = "${plan.price}€ / mes")
            }
            IconButton(
                onClick = { onAddToCart(plan) },
            ) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Añadir plan mensual")
            }
        }
    }
}

@Composable
fun CarritoPlanes(
    products: List<Product>,
    plans: List<MonthlyPlan>,
    onProductRemoved: (Product) -> Unit,
    onPlanRemoved: (MonthlyPlan) -> Unit
) {
    LazyColumn {
        item {
            Text(text = "Productos en el carrito:")
            products.forEach { product ->
                Text(text = "${product.name} - ${product.price} - Cantidad: ${product.quantity}")
                Button(onClick = { onProductRemoved(product) }) {
                    Text(text = "Eliminar")
                }
            }
            plans.forEach { plan ->
                CardPlanesMensuales(plan = plan, onPlanRemoved)
            }
        }
    }
}

@Composable
fun CardPlanesMensuales(plan: MonthlyPlan, onPlanRemoved: (MonthlyPlan) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = plan.name)
                Text(text = "${plan.price} / mes")
            }
            IconButton(
                onClick = { onPlanRemoved(plan) },
            ) {
                Icon(imageVector = Icons.Rounded.Clear, contentDescription = "Eliminar plan mensual")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoPlanMensual() {
    val products = remember { mutableStateListOf<Product>() }
    val plans = remember { mutableStateListOf<MonthlyPlan>() }
    Scaffold(
        topBar = { TopAppBarCarrito() }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PlanesMensuales(plan = MonthlyPlan("DinoBasic", 9.99)) {
                plans.add(it)
            }
            PlanesMensuales(plan = MonthlyPlan("DinoPro", 14.99)) {
                plans.add(it)
            }
            PlanesMensuales(plan = MonthlyPlan("DinoPremium", 24.99)) {
                plans.add(it)
            }

            CarritoPlanes(products = products, plans = plans,
                onProductRemoved = { product -> products.remove(product) },
                onPlanRemoved = { plan -> plans.remove(plan) }
            )
            Button(onClick = { /*TODO*/ },
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .paddingFromBaseline(40.dp)) {
                Text(text = "Continuar pedido")
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCarrito() {
    TopAppBar(
        title = {
            Text(
                text = "Carrito",
                fontSize = 18.sp
            )
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier,
        navigationIcon = { },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Atras"
                )
            }

        }
    )
}