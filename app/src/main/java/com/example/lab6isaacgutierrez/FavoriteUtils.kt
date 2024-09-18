package com.example.lab6isaacgutierrez

import android.content.Context
import android.content.SharedPreferences

fun saveFavorite(context: Context, eventId: String) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("Favorites", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(eventId, true)
    editor.apply()
}

fun isFavorite(context: Context, eventId: String): Boolean {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("Favorites", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(eventId, false)
}
