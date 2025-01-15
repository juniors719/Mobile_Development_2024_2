package com.example.plango.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Trip(
    val id: String,                             // Identificador único da viagem
    val name: String,                           // Nome da viagem
    val description: String?,                   // Descrição opcional
    val startDate: String?,                      // Data de início da viagem (formato ISO 8601 ou customizado)
    val endDate: String?,                       // Data de término da viagem
    val destination: String,
    val imageUrl: String?                       // URL da imagem associada à viagem
)