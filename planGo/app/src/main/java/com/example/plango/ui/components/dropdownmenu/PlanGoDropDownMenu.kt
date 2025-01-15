package com.example.plango.ui.components.dropdownmenu

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.plango.R

@Composable
fun PlanGoDropdownMenu(
    modifier: Modifier = Modifier,
    menuState: MutableState<Boolean>,
    onNavigateTo: (String) -> Unit
) {
    IconButton(
        onClick = { menuState.value = true }
    ) {
        Icon(Icons.Default.MoreVert, contentDescription = "Mais opções")
    }
    DropdownMenu(
        modifier = modifier,
        expanded = menuState.value,
        onDismissRequest = { menuState.value = false }
    ) {
        PlanGoDropDownMenuItem(label = "Home", iconRes = R.drawable.ic_home, onClick = {})
        PlanGoDropDownMenuItem(label = "Configurações", iconRes = R.drawable.ic_settings, onClick = {
            onNavigateTo("settings")
            menuState.value = false
        })
        PlanGoDropDownMenuItem(label = "Ajuda", iconRes = R.drawable.ic_help, onClick = {})
        PlanGoDropDownMenuItem(label = "Sobre", iconRes = R.drawable.ic_info, onClick = {})
    }
}