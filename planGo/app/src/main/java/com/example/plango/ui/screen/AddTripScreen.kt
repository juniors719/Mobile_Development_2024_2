package com.example.plango.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plango.R
import com.example.plango.data.mock.mockTrips
import com.example.plango.data.model.Trip
import com.example.plango.ui.components.button.PlanGoButton
import com.example.plango.ui.screen.addtrip.AddTripDatefield
import com.example.plango.ui.screen.addtrip.AddTripTextField
import com.example.plango.ui.theme.PlanGoTheme
import com.example.plango.ui.theme.Typography
import com.example.plango.utils.PlanGoSideEffect
import java.util.UUID

data class TripData (
    var id: String = UUID.randomUUID().toString(),
    var name: String = "",
    var description: String = "",
    var startDate: String = "",
    var endDate: String = "",
    var destination: String = "",
)

@ExperimentalMaterial3Api
@Composable
fun AddTripScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {

    val tripData = remember {
        mutableStateOf(TripData())
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Adicionar Viagem",
                        style = Typography.headlineLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateToHome() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        PlanGoSideEffect()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AddTripTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = tripData.value.destination,
                        onValueChange = { tripData.value = tripData.value.copy(destination = it) },
                        label = "Onde você quer ir?",
                        placeholder = "Cidade, País ou Região",
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_map_pin),
                                contentDescription = "Localização",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    AddTripTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = tripData.value.name,
                        onValueChange = { tripData.value = tripData.value.copy(name = it) },
                        label = "Como você quer chamar?",
                        placeholder = "Dê um título para a viagem",
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_edit),
                                contentDescription = "Título",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    AddTripTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = tripData.value.description.orEmpty(),
                        onValueChange = { tripData.value = tripData.value.copy(description = it) },
                        label = "Breve descrição (opcional)",
                        placeholder = "Adicione detalhes sobre sua viagem",
                        leadingIcon = {
                            Icon(
                                painter = painterResource(R.drawable.ic_description),
                                contentDescription = "Descrição",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        AddTripDatefield(
                            modifier = Modifier.weight(1f),
                            value = tripData.value.startDate,
                            onValueChange = {
                                tripData.value = tripData.value.copy(startDate = it)
                            },
                            label = "Data de Ida"
                        )
                        AddTripDatefield(
                            modifier = Modifier.weight(1f),
                            value = tripData.value.endDate,
                            onValueChange = {
                                tripData.value = tripData.value.copy(endDate = it)
                            },
                            label = "Data de Volta"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                PlanGoButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Adicionar Viagem",
                    onClick = {
                        if (tripData.value.destination.isEmpty()) {
                            tripData.value = tripData.value.copy(destination = "Campo obrigatório")
                        } else {
                            val newTrip = Trip(
                                id = tripData.value.id,
                                name = tripData.value.name,
                                description = tripData.value.description,
                                startDate = tripData.value.startDate,
                                endDate = tripData.value.endDate,
                                destination = tripData.value.destination,
//                                checklist = emptyList(),
//                                packingChecklist = emptyList(),
//                                events = emptyList(),
                                imageUrl = ""
                            )
                            mockTrips.add(newTrip)
                            onNavigateToHome()
                        }
                    },
                    upperCase = false,
                    iconRes = R.drawable.ic_checkcircle
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun AddTripScreenPreview() {
    PlanGoTheme {
        AddTripScreen()
    }
}