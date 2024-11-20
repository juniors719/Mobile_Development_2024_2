package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.counterapp.ui.theme.CounterAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.material.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0.0) }
    var input by remember { mutableStateOf("") }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado: $count",
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Digite um número: ")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    count += input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Incrementar", color = Color.White)
            }
            Button(
                onClick = {
                    count -= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Decrementar", color = Color.White)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    count *= input.toDoubleOrNull() ?: 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Multiplicar", color = Color.White)
            }
            Button(
                onClick = {
                    val divisor = input.toDoubleOrNull() ?: 0.0
                    if (divisor != 0.0) {
                        count /= divisor
                        input = ""
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Dividir", color = Color.White)
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    count = 0.0
                    input = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Resetar", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterAppPreview() {
    CounterAppTheme {
        CounterApp()
    }
}