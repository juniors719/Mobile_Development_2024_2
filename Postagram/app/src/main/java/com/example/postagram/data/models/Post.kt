package com.example.postagram.data.models

data class Post (
    val id: Int,
    val title: String,
    val content: String,
    val userId: Int
)

data class CreatePostRequest (
    val title: String,
    val content: String
)