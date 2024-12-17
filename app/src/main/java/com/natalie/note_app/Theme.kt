package com.natalie.note_app

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.natalie.note_app.ui.theme.*

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun NoteTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = CustomTypography,
        content = content
    )
}