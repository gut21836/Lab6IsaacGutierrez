package com.example.lab6isaacgutierrez

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.Composable

@Composable
fun FavoritesScreen() {
    val context = LocalContext.current
    val eventId = "1"  // Ejemplo de evento favorito

    // Observa el estado de si es favorito o no
    var isEventFavorite by remember { mutableStateOf(isFavorite(context, eventId)) }

    Column {
        Button(onClick = {
            saveFavorite(context, eventId)
            // Actualiza el estado para reflejar el cambio en la UI
            isEventFavorite = true
        }) {
            Text("Guardar en favoritos")
        }

        if (isEventFavorite) {
            Text(text = "El evento $eventId es favorito")
        }
    }
}
