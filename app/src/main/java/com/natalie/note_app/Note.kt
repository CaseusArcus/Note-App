package com.natalie.note_app

import java.util.UUID

data class Note (
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var text: String,
)

fun validateTitle(title: String): String? {
    return when {
        title.length < 3 -> "Title must be at least 3 characters"
        title.length > 50 -> "Title can be at most 50 characters"
        else -> null
    }
}

fun validateText(text: String): String? {
    return if (text.length > 120)
        "Text can be at most 120 characters"
    else
        null
}