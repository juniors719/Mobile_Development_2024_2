package com.example.plango.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plango.ui.components.button.PlanGoButton
import com.example.plango.ui.components.welcome.WelcomeContent
import com.example.plango.ui.components.welcome.WelcomeHeader
import com.example.plango.utils.PlanGoSideEffect

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {}
) {
    PlanGoSideEffect()
    Spacer(modifier = Modifier.height(30.dp))
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 40.dp, vertical = 48.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WelcomeHeader()
        WelcomeContent()
        PlanGoButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Começar",
            onClick = onNavigateToHome
        )
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen(onNavigateToHome = {})
}