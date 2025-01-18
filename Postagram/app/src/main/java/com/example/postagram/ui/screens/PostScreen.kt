package com.example.postagram.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import com.example.postagram.data.models.Post
import com.example.postagram.ui.components.PGButton
import com.example.postagram.viewmodel.PostViewModel

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = viewModel()
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var editingPost by remember { mutableStateOf<Post?>(null) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isLoading = true
        viewModel.fetchPosts()
        isLoading = false
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Título") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text(text = "Conteúdo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        PGButton(
            onClick = {
                isLoading = true
                viewModel.createPost(
                    title,
                    content,
                    onSucess = {
                        Toast.makeText(context, "Post criado com sucesso", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    },
                    onError = {
                        Toast.makeText(context, "Erro ao criar post", Toast.LENGTH_SHORT).show()
                        isLoading = false
                    }
                )
                title = ""
                content = ""
            },
            modifier = Modifier.fillMaxWidth(),
            iconRes = Icons.Default.Add,
            text = "Criar Post"
        )
        Spacer(modifier = Modifier.padding(8.dp))
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            LazyColumn {
                items(viewModel.posts) { post ->
                    PostItem(
                        post = post,
                        onEdit = {
                            editingPost = it
                        },
                        onDelete = {
                            viewModel.deletePost(it)
                        }
                    )
                }
            }
        }
        if (editingPost != null) {
            AlertDialog(
                onDismissRequest = { editingPost = null },
                title = { Text(text = "Editar Post") },
                text = {
                    Column {
                        OutlinedTextField(
                            value = editingPost!!.title,
                            onValueChange = { newTitle ->
                                editingPost = editingPost!!.copy(title = newTitle)
                            },
                            label = { Text(text = "Título") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        OutlinedTextField(
                            value = editingPost!!.content,
                            onValueChange = { newContent ->
                                editingPost = editingPost!!.copy(content = newContent)
                            },
                            label = { Text(text = "Conteúdo") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.updatePost(
                                editingPost!!.id,
                                editingPost!!.title,
                                editingPost!!.content
                            )
                            editingPost = null
                        }
                    ) {
                        Text(text = "Salvar")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { editingPost = null }
                    ) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PostScreen()
}