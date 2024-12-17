package com.natalie.note_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(navController: NavHostController, notes: MutableList<Note>) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController = navController, notes = notes) }
        composable("create") { CreateScreen(navController = navController, notes = notes) }
        composable("update/{noteId}") { backStackEntry: NavBackStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            if (noteId != null) {
                UpdateScreen(navController = navController, notes = notes, noteId = noteId)
            }
        }
    }
}