package com.example.practica2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    Scaffold(
        topBar = { Toolbar() },
        floatingActionButton = { FAB() }
        // En Material 3, la posición del botón ya es por defecto a la derecha (End), así que no hace falta declararlo.
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.Black)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.images),
                    contentDescription = "Solair de astora",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                )
                Text(
                    text = "Solair de astora",
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    text = "AARON DAHIR LORENZANA HERNANDEZ",
                    fontSize = 32.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "HOLA MUNDOOOOOO",
                    color = Color.White
                )
                Text(
                    text = "PRACTICA 2",
                    color = Color.White
                )
                Text(
                    text = "Me gustan los pixel musho",
                    color = Color.White
                )

                Greeting(name = "Aaron")

                MyRowExample()
            }
        }
    }
}

// En Material 3, TopAppBar es experimental, por lo que usamos esta etiqueta
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(text = "Aplicaciom de Aaron Dahir", color = Color.White)
        },
        // En Material 3, el color se cambia usando colors = TopAppBarDefaults
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray
        )
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current

    FloatingActionButton(
        onClick = {
            Toast.makeText(context, "Suscríbete", Toast.LENGTH_SHORT).show()
        },
        // En Material 3, backgroundColor pasó a llamarse containerColor
        containerColor = Color.DarkGray
    ) {
        Text(text = "X", color = Color.White)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Hello $name!", color = Color.White)

        var counter by rememberSaveable { mutableStateOf(10) }

        Row(modifier = Modifier.padding(top = 16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.descargar),
                contentDescription = "like",
                modifier = Modifier.clickable {
                    counter++
                }
            )

            Text(
                text = counter.toString(),
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White
            )
        }
    }
}

@Composable
fun MyRowExample() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        item { Text(text = "Practica 3", color = Color.White) }
        item { Text(text = "Practica 3", color = Color.White) }
        item { Text(text = "HOLA", color = Color.White) }
        item { Text(text = "PROFE", color = Color.White) }
        item { Text(text = "COMO", color = Color.White) }
        item { Text(text = "ESTA", color = Color.White) }
        item { Text(text = "LE", color = Color.White) }
        item { Text(text = "MANDO", color = Color.White) }
        item { Text(text = "UN", color = Color.White) }
        item { Text(text = "SALUDO", color = Color.White) }
    }
}