package com.natalie.note_app

import androidx.compose.runtime.*

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun NoteData (
    title: String,
    onTitleChange: (String) -> Unit,
    text:String,
    onTextChange: (String) -> Unit,
    onSave: () -> Unit
) {
    var titleError by remember { mutableStateOf<String?>(null) }
    var textError by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Title") },
            isError = titleError != null,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                disabledTextColor = Color.Gray,
                errorTextColor = MaterialTheme.colorScheme.error
            )
        )
        titleError?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            label = { Text("Text") },
            isError = textError != null,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Gray,
                disabledTextColor = Color.Gray,
                errorTextColor = MaterialTheme.colorScheme.error
            )
        )
        textError?.let { Text(it, color = Color.Red) }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                titleError = validateTitle(title)
                textError = validateText(text)
                if (titleError == null && textError == null) {
                    onSave()
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Save")
        }
    }
}