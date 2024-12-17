package com.natalie.note_app

import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun UpdateScreen(navController: NavController, notes: MutableList<Note>, noteId: String) {
    val note = notes.find { it.id == noteId } ?: return

    var title by remember { mutableStateOf(note.title) }
    var text by remember { mutableStateOf(note.text) }

    NoteData(
        title = title,
        onTitleChange = { title = it },
        text = text,
        onTextChange = { text = it },
        onSave = {
            val updatedNote = note.copy(title = title, text = text)
            val index = notes.indexOf(note)
            if (index >= 0) {
                notes[index] = updatedNote
            }
            navController.navigate("main")
        }
    )
}