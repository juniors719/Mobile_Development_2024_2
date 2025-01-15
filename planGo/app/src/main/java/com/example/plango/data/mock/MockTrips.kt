package com.example.plango.data.mock

import com.example.plango.data.model.ChecklistItem
import com.example.plango.data.model.Event
import com.example.plango.data.model.Trip

var mockTrips = mutableListOf<Trip>(
    Trip(
        id = "1",
        name = "Explorando os Alpes Suíços",
        description = "Aventuras nas montanhas com trilhas e paisagens deslumbrantes.",
        startDate = "2024-12-30",
        endDate = "2025-01-02",
        destination = "Zermatt, Suíça",
//        checklist = listOf(
//            ChecklistItem(id = "1", title = "Reservar hotel em Zermatt", isChecked = true),
//            ChecklistItem(id = "2", title = "Verificar condições climáticas", isChecked = false)
//        ),
//        packingChecklist = listOf(
//            ChecklistItem(id = "1", title = "Casaco de neve", isChecked = true),
//            ChecklistItem(id = "2", title = "Gorro e luvas térmicas", isChecked = false),
//            ChecklistItem(id = "3", title = "Botas de caminhada", isChecked = true),
//            ChecklistItem(id = "4", title = "Casaco de neve", isChecked = true),
//            ChecklistItem(id = "5", title = "Gorro e luvas térmicas", isChecked = false),
//            ChecklistItem(id = "6", title = "Botas de caminhada", isChecked = true)
//        ),
//        events = listOf(
//            Event(
//                id = "1",
//                title = "Passeio pelo Matterhorn",
//                description = "Subida guiada para ver a icônica montanha Matterhorn.",
//                dateTime = "2024-12-31T09:00:00",
//                location = "Zermatt, Suíça",
//                imageUrl = "https://example.com/matterhorn.png"
//            )
//        ),
        imageUrl = "https://content.r9cdn.net/rimg/dimg/58/e8/dec1e2a2-city-40374-162f7a10751.jpg"
    ),
    Trip(
        id = "2",
        name = "Descanso em Maldivas",
        description = "Relaxamento em um dos destinos mais paradisíacos do mundo.",
        startDate = "2025-01-15",
        endDate = "2025-01-20",
        destination = "Malé, Maldivas",
//        checklist = listOf(
//            ChecklistItem(id = "1", title = "Reservar bangalô sobre a água", isChecked = true),
//            ChecklistItem(id = "2", title = "Organizar transporte marítimo", isChecked = true),
//            ChecklistItem(id = "3", title = "Levar protetor solar", isChecked = false)
//        ),
//        packingChecklist = listOf(
//            ChecklistItem(id = "1", title = "Roupas de banho", isChecked = true),
//            ChecklistItem(id = "2", title = "Chapéu de sol", isChecked = false),
//            ChecklistItem(id = "3", title = "Câmera para fotos subaquáticas", isChecked = true)
//        ),
//        events = listOf(
//            Event(
//                id = "1",
//                title = "Mergulho com snorkel",
//                description = "Exploração dos recifes de corais das Maldivas.",
//                dateTime = "2025-01-17T10:00:00",
//                location = "Atol de Malé Norte, Maldivas",
//                imageUrl = "https://example.com/snorkel.png"
//            )
//        ),
        imageUrl = "https://ilhasmaldivas.com.br/wp-content/uploads/2021/10/ilhas-maldivas-galeria-vakkaru-resort-02.jpg"
    ),
    Trip(
        id = "3",
        name = "Tour Histórico por Roma",
        description = "Imersão na história e arquitetura da cidade eterna.",
        startDate = "2025-02-10",
        endDate = "2025-02-14",
        destination = "Roma, Itália",
//        checklist = listOf(
//            ChecklistItem(id = "1", title = "Comprar ingressos para o Coliseu", isChecked = false),
//            ChecklistItem(id = "2", title = "Reservar guia para o Vaticano", isChecked = true)
//        ),
//        packingChecklist = listOf(
//            ChecklistItem(id = "1", title = "Roupas confortáveis para caminhar", isChecked = true),
//            ChecklistItem(id = "2", title = "Guia de viagem de Roma", isChecked = false),
//            ChecklistItem(id = "3", title = "Mochila para o dia a dia", isChecked = true)
//        ),
//        events = listOf(
//            Event(
//                id = "1",
//                title = "Visita ao Coliseu",
//                description = "Descobrir a história do anfiteatro mais famoso do mundo.",
//                dateTime = "2025-02-11T10:00:00",
//                location = "Coliseu, Roma, Itália",
//                imageUrl = "https://example.com/coliseu.png"
//            ),
//            Event(
//                id = "2",
//                title = "Passeio pela Fontana di Trevi",
//                description = "Apreciar a fonte icônica e jogar uma moeda para dar sorte.",
//                dateTime = "2025-02-12T15:00:00",
//                location = "Fontana di Trevi, Roma, Itália",
//                imageUrl = "https://example.com/fontana.png"
//            )
//        ),
        imageUrl = "https://example.com/roma.png"
    )
)
