package com.example.pc02_moviles_22200125_22200111.data

import kotlinx.serialization.Serializable

@Serializable
data class Team(
    val id: String = "",
    val name: String = "",
    val foundationYear: String = "",
    val titles: String = "",
    val crestUrl: String = ""
)