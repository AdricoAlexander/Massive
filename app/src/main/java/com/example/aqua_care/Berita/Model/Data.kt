package com.example.aqua_care.Berita.Model

data class Data(
    val description: String,
    val image: String,
    val link: String,
    val posts: List<Post>,
    val title: String
)