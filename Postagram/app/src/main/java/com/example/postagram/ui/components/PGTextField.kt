package com.example.postagram.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PGTextField(
    modifier: Modifier = Modifier,
    label: String? = null,
    value: String,
    onValueChange: (String) -> Unit,
    leadingIcon: ImageVector? = null,
    placeholder: String? = null
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            label = label?.let { { Text(it) } },
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = "Ícone do campo de texto"
                    )
                }
            },
            placeholder = placeholder?.let { { Text(it) } },
            shape = RoundedCornerShape(8.dp)
        )
    }
}

@Preview
@Composable
private fun PGTextFieldPreview() {
    PGTextField(
        value = "Test",
        onValueChange = {},
        label = "Email",
        leadingIcon = Icons.Default.Email,
        placeholder = "Digite seu email"
    )
}