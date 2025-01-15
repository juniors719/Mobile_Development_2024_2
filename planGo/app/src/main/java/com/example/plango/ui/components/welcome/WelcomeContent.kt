package com.example.plango.ui.components.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.plango.R

@Composable
fun WelcomeContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Organize sua mala e tarefas",
            subtitle = "Crie checklists para garantir que você não vai esquecer nada.",
            iconRes = R.drawable.ic_checklist
        )
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Planeje em detalhes o seu rolê",
            subtitle = "Adicione localizações e detalhes importantes para cada parada.",
            iconRes = R.drawable.ic_calendar
        )
        WelcomeTips(
            modifier = Modifier.fillMaxWidth(),
            title = "Capture momentos inesquecíveis!",
            subtitle = "Incorpore imagens às suas anotações para lembrar cada detalhe.",
            iconRes = R.drawable.ic_camera
        )
    }
}

@Preview
@Composable
private fun WelcomeContentPreview() {
    WelcomeContent()
}