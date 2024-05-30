package com.example.aqua_care.Data

import androidx.compose.ui.graphics.painter.Painter
import com.example.aqua_care.Navigation.navScreen

data class bottomBar(
    val title: String,
    val icon: Painter,
    val selectedIcon : Painter,
    val screen : navScreen,
)

data class menuModul(
    val id : Int,
    val title: String,
    val description: String,
)

data class berita(
    val id: Int,
    val title: String,
    val image : Int = 0,
    val date : String,
    val website: String
)

data class premium(
    val id : Int,
    val title: String,
    val price: String,
    val length : String,
)