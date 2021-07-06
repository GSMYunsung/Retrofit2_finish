package com.example.retrofit2_fin

data class baeminData(val data: Data)

data class Data(val content: ArrayList<Content>)

data class Content(
    val title: String,
    val created: String,
    val content: String
    )
