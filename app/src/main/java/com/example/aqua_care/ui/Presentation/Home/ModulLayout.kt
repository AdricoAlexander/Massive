package com.example.aqua_care.ui.Presentation.Home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aqua_care.Data.Modul
import com.example.aqua_care.Data.moduleCard

@Composable
fun ModulLayout(
    modifier: Modifier = Modifier,
    modul: Modul,
    onClicked : (Int) -> Unit
) {
    moduleCard(
        text = modul.videoamount,
        title = modul.title,
        name = modul.writtername,
        description = modul.description,
        image = modul.image,
        profilepic = modul.profilepic,
    ) {
        onClicked(modul.id)
    }
}