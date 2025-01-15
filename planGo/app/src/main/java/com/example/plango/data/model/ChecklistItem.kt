package com.example.plango.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ChecklistItem(
    val id: String,      // Identificador único do item
    val title: String,   // Nome do item
    val isChecked: Boolean // Status do item (marcado ou não)
)
