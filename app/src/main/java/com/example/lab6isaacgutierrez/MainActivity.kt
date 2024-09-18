package com.example.lab6isaacgutierrez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Laboratorio 6") }) },
        content = {
            AppNavigation(navController = navController)
        }
    )
}

@Composable
fun AppNavigation(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Eventos", "Lugares", "Perfil", "Favoritos")

    Column {
        TabRow(selectedTabIndex = selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = { Text(title) }
                )
            }
        }

        when (selectedTab) {
            0 -> EventListScreen(navController)
            1 -> PlaceListScreen()
            2 -> ProfileScreen()
            3 -> FavoritesScreen()
        }
    }
}

@Composable
fun EventListScreen(navController: NavHostController) {
    Column {
        // Ejemplo de evento con navegación a la pantalla de detalles
        ClickableText(
            text = AnnotatedString("Evento 1"),
            onClick = { navController.navigate("eventDetail/1") }
        )
        ClickableText(
            text = AnnotatedString("Evento 2"),
            onClick = { navController.navigate("eventDetail/2") }
        )
    }
}

@Composable
fun PlaceListScreen() {
    Text(text = "Listado de Lugares")
}

@Composable
fun ProfileScreen() {
    Text(text = "Perfil del Usuario")
}

@Composable
fun FavoritesScreen() {
    Text(text = "Lista de Favoritos")
}
