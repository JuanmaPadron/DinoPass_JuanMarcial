
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dinopass_juanmarcial.R
import com.example.dinopass_juanmarcial.screens.other.BottomAppBarContent

@Composable
fun PlanesMensuales(
    continuePerfil: () -> Unit,
    continueCatalogo: () -> Unit,
    continuePlanesMensuales: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarPlanesMensuales()
        },
        bottomBar = {
            BottomAppBarContent(continuePerfil, continueCatalogo, continuePlanesMensuales)
        },
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(listaDePlanes) { plan ->
                TarjetaPlan(plan = plan)
            }
        }
    }
}

@Composable
fun TarjetaPlan(plan: Plan) {
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
                text = plan.nombre,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 19.sp,

                )
            Text(text = "Más de ${plan.juegos}",
                color = Color.Black,
                fontSize = 13.sp)
            Text(text = "Nuevos juegos mensualmente",
                color = Color.Black,
                fontSize = 13.sp)
            Text(text = "Juegos de ${plan.plataforma}",
                color = Color.Black,
                fontSize = 13.sp)
            Button(onClick = {  },
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .paddingFromBaseline(140.dp)
            ) {
                Text(text = "Suscribirse",
                    color = Color.Black)
            }
        }
    }
}


data class Plan(
    val nombre: String,
    val juegos: String,
    val plataforma: String
)

val listaDePlanes = listOf(
    Plan(nombre = "DinoBasic", "5000 juegos", "PC"),
    Plan(nombre = "DinoPro", "10.000 juegos", "movil y PC"),
    Plan(nombre = "DinoPremium", "50.000 juegos", "movil, PC y consolas(PS5, PS4, Xbox series X)")

)

@Composable
fun CustomFamilyFont(): FontFamily {
    return FontFamily(
        Font(
            resId = R.font.fontdiner_swanky_regular, // Reemplaza con el ID de tu fuente personalizada
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPlanesMensuales(modifier: Modifier = Modifier) {
    val customFontFamily = CustomFamilyFont()

    TopAppBar(
        title = {
            Text(
                text = "Planes Mensuales",
                fontFamily = customFontFamily,
                fontSize = 18.sp
            )
        },
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
