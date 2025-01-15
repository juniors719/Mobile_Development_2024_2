package com.example.plango.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plango.R
import com.example.plango.data.mock.mockTrips
import com.example.plango.ui.components.button.PlanGoButton
import com.example.plango.ui.theme.PlanGoTheme
import com.example.plango.ui.theme.Typography

@Composable
fun TripDetailsScreen(
    modifier: Modifier = Modifier,
    tripId: String?,
    onNavigateBack: () -> Unit = {}
) {
    val trip = mockTrips.find { it.id == tripId } ?: mockTrips.first()
    Box(
        modifier = modifier.fillMaxSize().padding(top = 16.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize(0.3f),
            contentDescription = "Imagem da viagem",
            contentScale = ContentScale.Crop,
//            model = trip.imageUrl
            painter = painterResource(R.drawable.zermatt) // TODO: Substituir pela imagem do estabelecimento
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Column {
                        // Título
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = trip.name, style = Typography.headlineLarge)
                        Spacer(modifier = Modifier.height(16.dp))
                        // Descrição
                        trip.description?.let {
                            Text(text = it, style = Typography.bodyLarge)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        // Localização
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_map_pin),
                                contentDescription = "Localização",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(32.dp)
                            )
                            Text(text = trip.destination, style = Typography.headlineMedium)
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        // Data de início e fim
                        TripDetailsDate(
                            dataInicio = trip.startDate ?: "",
                            dataFim = trip.endDate ?: ""
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        // Checklist pré-viagem
                        Column(
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        ) {
//                            if (trip.checklist.isNotEmpty()) {
//                                Text(text = "Checklist pré-viagem", style = Typography.headlineMedium)
//                                Spacer(modifier = Modifier.height(8.dp))
//
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(vertical = 8.dp)
//                                ) {
//                                    trip.checklist.forEach { item ->
//                                        val isChecked = remember { mutableStateOf(item.isChecked) }
//                                        TripChecklistItem(
//                                            itemName = item.title,
//                                            isChecked = isChecked
//                                        )
//                                    }
//                                }
//                            }
//                            Spacer(modifier = Modifier.height(24.dp))
//                            // Checklist pré-viagem
//                            if (trip.packingChecklist.isNotEmpty()) {
//                                Text(text = "Itens da Mala", style = Typography.headlineMedium)
//                                Spacer(modifier = Modifier.height(8.dp))
//
//                                Column(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(vertical = 8.dp)
//                                ) {
//                                    trip.packingChecklist.forEach { item ->
//                                        val isChecked = remember { mutableStateOf(item.isChecked) }
//                                        TripChecklistItem(
//                                            itemName = item.title,
//                                            isChecked = isChecked
//                                        )
//                                    }
//                                }
//                            }
                        }
                    }
                }
            }
        }
        PlanGoButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp),
            iconRes = R.drawable.ic_arrow_left,
            onClick = onNavigateBack
        )
    }
}

@Composable
fun TripDetailsDate(modifier: Modifier = Modifier, dataInicio: String, dataFim: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = "Ícone calendário",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "$dataInicio ~ $dataFim",
            style = Typography.bodyLarge
        )
    }
}

@Preview
@Composable
private fun TripDetailsScreenPreview() {
    PlanGoTheme {
        TripDetailsScreen(tripId = "1")
    }
}