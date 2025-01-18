package com.example.postagram.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PGButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    iconRes: ImageVector? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    upperCase: Boolean = true
) {
    Button(
        modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colors.primary,
            contentColor = MaterialTheme.colors.onPrimary
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = it,
                    contentDescription = "Ícone do botão"
                )
            }
            text?.let {
                Text(
                    text = if (upperCase) it.uppercase() else it,
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }

}

@Preview
@Composable
private fun PGButtonPreview() {
    PGButton(
        text = "Cadastrar",
        iconRes = Icons.Default.Add,
        onClick = {}
    )
}