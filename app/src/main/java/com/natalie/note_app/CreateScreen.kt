package com.natalie.note_app

import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun CreateScreen(navController: NavController, notes: MutableList<Note>) {
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }

    NoteData(
        title = title,
        onTitleChange = { title = it },
        text = text,
        onTextChange = { text = it },
        onSave = {
            notes.add(Note(
                id = System.currentTimeMillis().toString(),
                title = title,
                text = text
            ))
            navController.navigate("main")
        }
    )
}