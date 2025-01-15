package com.example.plango.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val id: String,      // Identificador único do evento
    val title: String,   // Nome do evento
    val description: String?, // Descrição do evento
    val dateTime: String, // Data e hora do evento (formato ISO 8601 ou customizado)
    val location: String, // Local do evento
    val imageUrl: String? // URL da imagem associada ao evento (opcional)
)