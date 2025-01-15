package com.example.plango.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plango.R
import com.example.plango.data.mock.mockTrips
import com.example.plango.data.model.Trip
import com.example.plango.ui.components.bottomnavigationbar.PlanGoBottonNavBar
import com.example.plango.ui.components.button.PlanGoButton
import com.example.plango.ui.components.dropdownmenu.PlanGoDropdownMenu
import com.example.plango.ui.components.trip.PlanGoTripCard
import com.example.plango.ui.theme.PlanGoTheme
import com.example.plango.ui.theme.Typography
import com.example.plango.utils.PlanGoSideEffect

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToAddTrip: () -> Unit = {},
    onNavigateToTripDetails: (Trip) -> Unit = {},
    onNavigateToHelp: () -> Unit = {},
    onNavigateToSettings: () -> Unit = {},
    onNavigateToInfo: () -> Unit = {}
) {
    val isMenuOpen = remember { mutableStateOf(false) }
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "PlanGo",
                        style = Typography.headlineLarge
                    )
                },
                actions = {
                    PlanGoDropdownMenu(
                        menuState = isMenuOpen,
                        onNavigateTo = {
                            when (it) {
                                "help" -> onNavigateToHelp()
                                "settings" -> onNavigateToSettings()
                                "info" -> onNavigateToInfo()
                                else -> {}
                            }
                        }
                    )
                }
            )
        },
        bottomBar = {
            PlanGoBottonNavBar(
                modifier = Modifier.fillMaxWidth(),
                onNavigate = {}
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
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Minhas viagens:",
                    style = Typography.headlineMedium
                )
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(mockTrips) {
                        PlanGoTripCard(
                            trip = it,
                            onClick = { selectedMarket ->
                                onNavigateToTripDetails(selectedMarket)
                            }
                        )
                    }
                }
                PlanGoButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Criar nova viagem",
                    iconRes = R.drawable.ic_add,
                    onClick = onNavigateToAddTrip
                )
            }
        }
    }
}


@Preview
@ExperimentalMaterial3Api
@Composable
private fun HomeScreenPreview() {
    PlanGoTheme {
        HomeScreen()
    }
}