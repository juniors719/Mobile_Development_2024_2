package com.example.postagram.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.postagram.ui.components.PGButton
import com.example.postagram.viewmodel.PostViewModel

@Composable
fun UserScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchUsers()
        isLoading = false
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(value = name,
            onValueChange = { name = it },
            label = { Text(text = "Nome") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person, contentDescription = "Ícone usuário"
                )
            })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email, contentDescription = "Ícone Email"
                )
            })
        Spacer(modifier = Modifier.height(8.dp))
        PGButton(
            text = "Criar Usuário",
            iconRes = Icons.Default.Add,
            onClick = {
                isLoading = true
                viewModel.createUser(name, email, onSucess = {
                    Toast.makeText(context, "Usuário criado com sucesso!", Toast.LENGTH_SHORT)
                        .show()
                    isLoading = false
                }, onError = {
                    Toast.makeText(context, "Erro ao criar usuário!", Toast.LENGTH_SHORT).show()
                    isLoading = false
                })
                name = ""
                email = ""
            }, modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(8.dp))
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn {
                items(viewModel.users) { user ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), elevation = 4.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Nome: ${user.name}", style = MaterialTheme.typography.h6
                            )
                            Text(
                                text = "Email: ${user.email}",
                                style = MaterialTheme.typography.body1
                            )
                        }
                    }
                }
            }
        }
    }

}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen()
}