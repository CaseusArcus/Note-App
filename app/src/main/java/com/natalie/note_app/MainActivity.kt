package com.natalie.note_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val notes = remember { mutableStateListOf<Note>() }

            NoteTheme {
                NavigationGraph(navController = navController, notes = notes)
            }
        }
    }
}